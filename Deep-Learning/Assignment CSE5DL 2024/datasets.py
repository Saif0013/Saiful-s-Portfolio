import collections
import csv
from pathlib import Path

import pandas as pd
import numpy as np
import torch
import torchvision.transforms as transforms
from PIL import Image
from transformers import AutoTokenizer

# TODO Task 1b - Implement LesionDataset

class LesionDataset(torch.utils.data.Dataset):
    
    def __init__(self, img_dir, labels_fname, augment=False, transform=None):

        # Initialize the dataset with the directory 
        # containing images and the CSV file with labels
        self.img_dir = Path(img_dir) 

        # read the csv file 
        self.labels_df = pd.read_csv(labels_fname) 

        # convert image ids to a list
        self.image_ids = self.labels_df['image'].tolist() 

        # Get class names from the dataset
        self.class_names = self._get_class_names() 

        # len of classes
        self.num_classes = len(self.class_names) 

        # set augmentation flag
        self.augment = augment 
        
        # augment transformation
        self.augmentations = transforms.Compose([
            transforms.RandomHorizontalFlip(0.5),
            transforms.RandomVerticalFlip(0.5),
            transforms.RandomRotation(45)
        ])
        
        # set transform
        self.transform = transform 
        

    def __len__(self):

        # Return the total number of samples in the dataset
        return len(self.labels_df)
    
    def __getitem__(self, idx):

        # Retrieve the image ID and construct the path to the image
        img_id = self.image_ids[idx]
        img_path = self.img_dir / f'{img_id}.jpg' 
        
        # Open the image using PIL (Python Imaging Library)
        image = Image.open(img_path) 

        # Apply augmentation if the flag is set to True
        if self.augment:
            image = self.augmentations(image) 

        # Convert the PIL image to a PyTorch tensor 
        # and transpose the dimensions
        # Transpose the dimensions to have channels 
        # as the second dimension [channels, height, width] 
        # apply transform, if it is set
        if self.transform:
          image = self.transform(image) 
        else:
          image = transforms.ToTensor()(image)
          image = image.permute(0, 1, 2)

        # Extract the corresponding label for the image
        label = self.labels_df.iloc[idx, 1:].values.argmax() 
        
        return image, label 


    def _get_class_names(self):

        # Get the list of class names from the dataset.
        # class names are column names 
        # in the DataFrame excluding the first column (image IDs).
        return list(self.labels_df.columns[1:])   
        





# TODO Task 2b - Implement TextDataset

class TextDataset(torch.utils.data.Dataset):
    
    def __init__(self, fname, sentence_len): 
        
        # define column names
        column_names = ['Label', 'Title', 'Content']
                
        # read the csv file
        df = pd.read_csv(fname, header=None, names=column_names)
        
        # initialize the texts and labels
        texts = df['Content'].tolist() 
        labels = df['Label'].tolist() 

        # Adjust class labels to start from 0
        labels = [label - 1 for label in labels]
                
        # set the tokenizer
        tokenizer = AutoTokenizer.from_pretrained("distilbert-base-uncased") 

        # store the number of words in the tokenizer's vocabulary
        self.vocab_size = tokenizer.vocab_size 

        # tokenize the texts
        tokens = tokenizer(texts, truncation=True, padding=True,
                    max_length=sentence_len, return_tensors="pt") 

        self.tokens = tokens["input_ids"] 
        self.labels = labels 
    
    def __len__(self):
        return len(self.labels) 
    
    def __getitem__(self, idx):
        tokens = self.tokens[idx]
        label = self.labels[idx] 
    
        return tokens, label




    
