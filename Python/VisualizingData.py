import matplotlib.pyplot as plt

# Path to the Java output file
filename = "output.txt"   # Change this to your file name

# Lists to store data
n_values = []
detLU = []
countLU = []
timeLU = []
detLaplace = []
countLaplace = []
timeLaplace = []

# Read data from file
with open(filename, "r") as f:
    for line in f:
        parts = line.strip().split()
        if len(parts) != 7:
            continue  # Skip invalid lines
        n, dLU, cLU, tLU, dLap, cLap, tLap = parts
        n_values.append(int(n))
        detLU.append(float(dLU))
        countLU.append(int(cLU))
        timeLU.append(float(tLU))
        detLaplace.append(float(dLap))
        countLaplace.append(int(cLap))
        timeLaplace.append(float(tLap))

#Ploting Execution Time
plt.figure(figsize=(8, 5))
plt.plot(n_values, timeLU, 'o-', label="LU Decomposition")
plt.plot(n_values, timeLaplace, 's-', label="Laplace Expansion")
plt.xlabel("Matrix Size (n)")
plt.ylabel("Execution Time (seconds)")
plt.title("Execution Time Comparison")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.show()

#Ploting Operation Count
plt.figure(figsize=(8, 5))
plt.plot(n_values, countLU, 'o-', label="LU Decomposition")
plt.plot(n_values, countLaplace, 's-', label="Laplace Expansion")
plt.xlabel("Matrix Size (n)")
plt.ylabel("Operation Count")
plt.title("Operation Count Comparison")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.show()

#Ploting Determinant Values
plt.figure(figsize=(8, 5))
plt.plot(n_values, detLU, 'o-', label="det(LU)")
plt.plot(n_values, detLaplace, 's-', label="det(Laplace)")
plt.xlabel("Matrix Size (n)")
plt.ylabel("Determinant Value")
plt.title("Determinant Comparison")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.show()
