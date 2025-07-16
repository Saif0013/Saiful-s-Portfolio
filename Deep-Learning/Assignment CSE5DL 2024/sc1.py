import torch
import torch.nn as nn

#  ==== Put your solutions here ====
# Each function receives an nn.Linear.
# Hint #1: Make sure you print out the shape of the weights
# Hint #2: You can fill multiple weights at once by assigning
#  the weights to a tensor. e.g.
# lin.weight.data[:] = torch.tensor([
#     [1, 0],
#     [0, 1],
# ], dtype=lin.weight.dtype, device=lin.weight.device)

# question one
# Given an nn.Linear(1, 1) layer, 
# set the weights such that the layer adds 1 to it's input.
def modify_lin_1(layer):
    # Set the weight to 1 so that the input remains unchanged
    layer.weight.data[:] = 1.0
    # Set the bias to 1 to add 1 to the input
    layer.bias.data[:] = 1.0 
    

# question two
# Given an nn.Linear(1, 1) layer, 
# set the weights such that the layer calculates y = 3x + 2.
def modify_lin_2(layer):
    # set the weight to 3 to multiply the input by 3
    layer.weight.data[:] = 3
    # set the bias to 2 to add 2 to the input
    layer.bias.data[:] = 2 
    

# question three
# Given an nn.Linear(4, 1) layer, 
# set the weights such that the layer calculates the average of it's inputs.
def modify_lin_3(layer):
    # set the weight to 0.25 to calculate
    # the average of 4 inputs
    layer.weight.data[:] = 0.25
    # set the bias to 0 since
    # bias is not necessary to calculate average
    layer.bias.data[:] = 0 


# question four
# Given an nn.Linear(4, 2) layer, 
# set the weights such that the layer calculates both the average of it's inputs
# and the sum of the inputs. 
def modify_lin_4(layer): 
    # set the first row of weights to 0.25
    # to calculate the average of 4 inputs
    layer.weight.data[0, :] = 0.25  
    # set the second row of weights to 1
    # to calculate the sum of 4 inputs
    layer.weight.data[1, :] = 1.0 
    # set the bias to 0 since
    # bias is not necessary to calculate average or sum
    layer.bias.data[:] = 0 


# question five
# Given an nn.Linear(3, 3) layer, 
# set the weights such that the layer returns the inputs, 
# but in reverse order. 
def modify_lin_5(layer): 
    # set the weight matrix to reverse the order of inputs
    layer.weight.data = torch.tensor([[0, 0, 1], [0, 1, 0], [1, 0, 0]], dtype=torch.float32) 
    # set the bias to 0 since bias is not necessary here
    layer.bias.data[:] = 0


# question six
# Given an nn.Linear(5, 2) layer, 
# set the weights such that the layer always returns (4,2) 
def modify_lin_6(layer): 
    # set all the weights to 0
    # so the output does not depend on the input
    layer.weight.data[:] = 0 
    # set the biases to 4 and 2 to always return (4,2 )
    layer.bias.data[:] = torch.tensor([4, 2], dtype=torch.float32)



#  ==== Testing code: Tests your solutions ====
def test_1(fnc):
    inp = torch.tensor([1., 5, 11, 20, 21]).reshape([-1, 1])
    tar = torch.tensor([2., 6, 12, 21, 22]).reshape([-1, 1])
    layer = nn.Linear(1, 1)
    fnc(layer)
    out = layer(inp)
    return torch.allclose(out, tar)

def test_2(fnc):
    inp = torch.tensor([1.,  5, 11, 20, 21]).reshape([-1, 1])
    tar = torch.tensor([5., 17, 35, 62, 65]).reshape([-1, 1])
    layer = nn.Linear(1, 1)
    fnc(layer)
    out = layer(inp)
    return torch.allclose(out, tar)

def test_3(fnc):
    inp = torch.tensor([
        [1., 1, 1, 1],
        [5, 10, 15, 20],
        [11, 20, 21, 25]
    ])
    tar = inp.mean(dim=1, keepdim=True)
    layer = nn.Linear(4, 1)
    fnc(layer)
    out = layer(inp)
    return torch.allclose(out, tar)

def test_4(fnc):
    inp = torch.tensor([
        [1., 1, 1, 1],
        [5, 10, 15, 20],
        [11, 20, 21, 25]
    ])
    tar = torch.stack([
        inp.mean(dim=1),
        inp.sum(dim=1)
    ], dim=1)
    layer = nn.Linear(4, 2)
    fnc(layer)
    out = layer(inp)
    return torch.allclose(out, tar)

def test_5(fnc):
    inp = torch.tensor([
        [1., 1, 1],
        [5, 10, 15],
        [11, 20, 21],
        [4, 12, 2],
        [6, 5, 4],
    ])
    tar = torch.tensor([
        [1., 1, 1],
        [15, 10, 5],
        [21, 20, 11],
        [2, 12, 4],
        [4, 5, 6],
    ])
    layer = nn.Linear(3, 3)
    fnc(layer)
    out = layer(inp)
    return torch.allclose(out, tar)

def test_6(fnc):
    inp = torch.tensor([
        [1., 2, 3, 4, 5],
        [1e5, 2e10, 3e15, 4e20, 5e25],
        [-150, 150, 15, -15, 0.1]
    ])
    tar = torch.tensor([
        [4., 2],
        [4, 2],
        [4, 2],
    ])
    layer = nn.Linear(5, 2)
    fnc(layer)
    out = layer(inp)
    return torch.allclose(out, tar) 