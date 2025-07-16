# app.py
import tkinter as tk
from MedicineApp.gui import MedicineAppGUI

if __name__ == "__main__":
    root = tk.Tk()
    app = MedicineAppGUI(root, csv_path="MedicineApp/Data/dictionary.csv")
    root.mainloop()
