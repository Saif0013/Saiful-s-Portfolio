import torch
import torch.nn as nn
import torchvision 
import torchvision.models as models 
from transformers import AutoModelForSequenceClassification


# TODO Task 1c - Implement a SimpleBNConv
class SimpleBNConv(nn.Module):
    def __init__(self, num_classes=7):
        super().__init__()
        self.seq = nn.Sequential(
            nn.Conv2d(3, 8, kernel_size=3, padding=1),
            nn.ReLU(),
            nn.BatchNorm2d(8),
            nn.MaxPool2d(kernel_size=2, stride=2),
            
            nn.Conv2d(8, 16, kernel_size=3, padding=1),
            nn.ReLU(),
            nn.BatchNorm2d(16),
            nn.MaxPool2d(kernel_size=2, stride=2),

            nn.Conv2d(16, 32, kernel_size=3, padding=1),
            nn.ReLU(),
            nn.BatchNorm2d(32),
            nn.MaxPool2d(kernel_size=2, stride=2),

            nn.Conv2d(32, 64, kernel_size=3, padding=1),
            nn.ReLU(),
            nn.BatchNorm2d(64),
            nn.MaxPool2d(kernel_size=2, stride=2),

            nn.Conv2d(64, 128, kernel_size=3, padding=1),
            nn.ReLU(),
            nn.BatchNorm2d(128),
            nn.MaxPool2d(kernel_size=2, stride=2)
        )
         # fully connected layer
        self.fc = nn.Linear(128 * 14 * 18, num_classes) 

    def forward(self, x):
        x = self.seq(x)
        x = x.view(x.size(0), -1) 
        x = self.fc(x)
        return x




# TODO Task 1f - Create a model from a pre-trained model from the torchvision
#  model zoo. 
# I have created multiple resnet model to explore model performance.

num_classes = 7

def construct_resnet18():
    # Download the pre-trained model
    resnet18 = models.resnet18(pretrained=True)

    # Freeze model weights
    for param in resnet18.parameters():
      param.requires_grad=False

    # Replace the final linear layer
    resnet18.fc = nn.Linear(512, num_classes)

    return resnet18 


# resnet34
def construct_resnet34(): 
    # Download the pretrained model
    resnet34 = models.resnet34(pretrained=True) 
    
    # freeze the model weights
    for param in resnet34.parameters():
        param.requires_grad = False 
        
    # replace the final linear layer
    resnet34.fc = nn.Linear(512, num_classes) 
    
    return resnet34 


# resnet50
def construct_resnet50(): 
    # Download pretrained model
    resnet50 = models.resnet50(pretrained=True) 
    
    # freeze the model weights
    for param in resnet50.parameters():
        param.requires_grad = False 
        
    # replace the final linear layer
    resnet50.fc = nn.Linear(2048, num_classes)
    return resnet50


# resnet152
def construct_resnet152(): 
    # Download pretrained model
    resnet152 = models.resnet152(pretrained=True) 
    
    # freeze the model weights
    for param in resnet152.parameters():
        param.requires_grad = False 
        
    # replace the final linear layer
    resnet152.fc = nn.Linear(2048, num_classes)
    return resnet152 




# TODO Task 1f - Create your own models
# Custom model
class CustomClassificationModel(nn.Module):
    def __init__(self, num_classes=7):
        super().__init__()
        self.seq = nn.Sequential(
            nn.Conv2d(3, 16, kernel_size=3, padding=1), 
            nn.ReLU(),
            nn.BatchNorm2d(16),
            nn.MaxPool2d(kernel_size=2, stride=2),

            nn.Conv2d(16, 32, kernel_size=3, padding=1),
            nn.ReLU(),
            nn.BatchNorm2d(32),
            nn.MaxPool2d(kernel_size=2, stride=2),

            nn.Conv2d(32, 64, kernel_size=3, padding=1),
            nn.ReLU(),
            nn.BatchNorm2d(64),
            nn.MaxPool2d(kernel_size=2, stride=2),

            nn.Conv2d(64, 128, kernel_size=3, padding=1), 
            nn.ReLU(),
            nn.BatchNorm2d(128),
            nn.MaxPool2d(kernel_size=2, stride=2),

            nn.Conv2d(128, 256, kernel_size=3, padding=1),
            nn.ReLU(),
            nn.BatchNorm2d(256),
            nn.MaxPool2d(kernel_size=2, stride=2)
        )
        self.fc1 = nn.Linear(256 * 14 * 18, 512) 
        self.fc2 = nn.Linear(512, num_classes)

    def forward(self, x):
        x = self.seq(x)
        x = x.view(x.size(0), -1)
        x = self.fc1(x)
        x = nn.ReLU()(x)
        x = self.fc2(x)
        return x









# TODO Task 2c - Complete the TextMLP class
class TextMLP(nn.Module):
    def __init__(self, vocab_size, sentence_len, hidden_size, n_classes=4):
        super().__init__()
        embedding_dim = 128  # Given embedding dimension
        self.seq = nn.Sequential(
            nn.Embedding(vocab_size, hidden_size//2),
            nn.Flatten(),
            nn.Linear(sentence_len * embedding_dim, hidden_size),
            nn.BatchNorm1d(hidden_size),
            nn.ReLU(),
            nn.Linear(hidden_size, hidden_size),
            nn.BatchNorm1d(hidden_size),
            nn.ReLU(),
            nn.Linear(hidden_size, hidden_size),
            nn.BatchNorm1d(hidden_size),
            nn.ReLU(),
            nn.Linear(hidden_size, hidden_size),
            nn.BatchNorm1d(hidden_size),
            nn.ReLU(),
            nn.Linear(hidden_size, hidden_size),
            nn.BatchNorm1d(hidden_size),
            nn.ReLU(),
            nn.Linear(hidden_size, hidden_size),
            nn.BatchNorm1d(hidden_size),
            nn.ReLU(),
            nn.Linear(hidden_size, hidden_size),
            nn.BatchNorm1d(hidden_size),
            nn.ReLU(),
            nn.Linear(hidden_size, hidden_size),
            nn.BatchNorm1d(hidden_size),
            nn.ReLU(),
            nn.Linear(hidden_size, n_classes)
        )
    
    def forward(self, x):
        return self.seq(x)




# TODO Task 2c - Create a model which uses a distilbert-base-uncased
#                by completing the following.
class DistilBertForClassification(nn.Module):
    def __init__(self, n_classes=4):
        super().__init__() 
        # load the pretrained model and replace the number of outputs
        self.model = AutoModelForSequenceClassification.from_pretrained(
            "distilbert-base-uncased", num_labels=n_classes) 
    
    def forward(self, input_ids, attention_mask=None): 
        # forward pass through the model
        outputs = self.model(input_ids=input_ids,
                            attention_mask=attention_mask) 
        # extract the logits from the output                    
        logits = outputs.logits 
        return logits






