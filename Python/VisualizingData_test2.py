import matplotlib.pyplot as plt
import math
import os
import re

# Folder containing test result files
folder = "test2"

# Data containers
n_values = []
countLU = []
countLaplace = []
timeLU = []
timeLaplace = []
ratio_LU_n3 = []
ratio_Laplace_fact = []

# Regular expressions to extract data
pattern_size = re.compile(r"Matrix size:\s*(\d+)")
pattern_LU_count = re.compile(r"Operation Count:\s*(\d+)")
pattern_Laplace_count = re.compile(r"Operation Count:\s*(\d+)", re.MULTILINE)
pattern_time = re.compile(r"Time \(ms\):\s*(\d+)")
pattern_ratio_LU = re.compile(r"Operation Count LU / n\^3:\s*([\d\.]+)")
pattern_ratio_Laplace = re.compile(r"Operation Count Laplace / n!:\s*([\d\.]+)")

# Loop through files output_1.txt to output_12.txt
for i in range(1, 14):
    filepath = os.path.join(folder, f"output_{i}.txt")
    if not os.path.exists(filepath):
        continue

    with open(filepath, "r") as f:
        text = f.read()

    # Extract matrix size
    match_size = pattern_size.search(text)
    if not match_size:
        continue
    n = int(match_size.group(1))
    n_values.append(n)

    # Extract LU section
    lu_section = re.search(r"LU Decomposition:(.*?)Laplace Expansion:", text, re.S)
    laplace_section = re.search(r"Laplace Expansion:(.*?)$", text, re.S)
    if not lu_section or not laplace_section:
        continue

    # Extract LU data
    lu_text = lu_section.group(1)
    lap_text = laplace_section.group(1)

    lu_count = int(re.search(r"Operation Count:\s*(\d+)", lu_text).group(1))
    lu_time = int(re.search(r"Time \(ms\):\s*(\d+)", lu_text).group(1))
    lap_count = int(re.search(r"Operation Count:\s*(\d+)", lap_text).group(1))
    lap_time = int(re.search(r"Time \(ms\):\s*(\d+)", lap_text).group(1))

    # Ratios
    ratio_n3 = lu_count / (n ** 3)
    ratio_fact = lap_count / math.factorial(n)

    countLU.append(lu_count)
    countLaplace.append(lap_count)
    timeLU.append(lu_time)
    timeLaplace.append(lap_time)
    ratio_LU_n3.append(ratio_n3)
    ratio_Laplace_fact.append(ratio_fact)

# ---------------- Plot 1: Operation Count ----------------
plt.figure(figsize=(16, 9))
plt.plot(n_values, countLU, 'o-', label="LU Decomposition")
plt.plot(n_values, countLaplace, 's-', label="Laplace Expansion")
plt.xlabel("Matrix Size (n)")
plt.ylabel("Operation Count")
plt.title("Operation Count Comparison")
plt.yscale("log")  # Use logarithmic scale because Laplace grows fast
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.show()

# ---------------- Plot 2: Computation Time ----------------
plt.figure(figsize=(16, 9))
plt.plot(n_values, timeLU, 'o-', label="LU Decomposition")
plt.plot(n_values, timeLaplace, 's-', label="Laplace Expansion")
plt.xlabel("Matrix Size (n)")
plt.ylabel("Time (ns)")
plt.title("Computation Time Comparison")
plt.yscale("log")
plt.legend()
plt.grid(True)
plt.tight_layout()
plt.show()

# ---------------- Plot 3: Operation Count LU / n³ ----------------
plt.figure(figsize=(16, 9))
plt.plot(n_values, ratio_LU_n3, 'o-', color='blue')
plt.xlabel("Matrix Size (n)")
plt.ylabel("Operation Count LU / n³")
plt.title("LU Decomposition Operation Count per n³")
plt.grid(True)
plt.tight_layout()
plt.show()

# ---------------- Plot 4: Operation Count Laplace / n! ----------------
plt.figure(figsize=(16, 9))
plt.plot(n_values, ratio_Laplace_fact, 's-', color='red')
plt.xlabel("Matrix Size (n)")
plt.ylabel("Operation Count Laplace / n!")
plt.title("Laplace Expansion Operation Count per n!")
plt.grid(True)
plt.tight_layout()
plt.show()
