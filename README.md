# Matrix-Determinant

A small Java project for computing the determinant of square matrices. It can be used as:
- A command‑line tool to compute determinants from files or standard input
- A library method you can call from your Java code

This project targets learning, correctness, and practical performance for moderate matrix sizes.

> NOTE: Replace the TODO items below (package names, class names, Java version, and exact CLI flags) with your repository’s actual values.

## Table of Contents
- [Features](#features)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Command-Line Usage](#command-line-usage)
- [Library Usage](#library-usage)
- [Algorithms](#algorithms)
- [Precision and Stability](#precision-and-stability)
- [Input Formats](#input-formats)
- [Examples](#examples)
- [Testing](#testing)
- [Project Structure](#project-structure)
- [Performance Notes](#performance-notes)
- [Roadmap](#roadmap)
- [License](#license)

## Features
- Determinant computation for n×n matrices
- Multiple methods:
  - Gaussian elimination with partial pivoting (default; O(n³))
  - LU decomposition (Doolittle/Crout; O(n³))
  - Laplace expansion / cofactor expansion (for very small n only; O(n!))
  - Sarrus rule for 3×3 (constant time)
- Optional method selection via CLI flag or API parameter
- Basic input parsing from CSV or whitespace‑separated numbers
- Clear error messages for non-square or malformed inputs

## Requirements
- Java: TODO (e.g., 11+ or 17+)
- Build tool:
  - Gradle (preferred), or
  - Maven
- Platform: Windows, macOS, Linux

## Quick Start
Clone and build:

Gradle:
```bash
git clone https://github.com/Ramin2005/Matrix-Determinant.git
cd Matrix-Determinant
./gradlew clean build
```

Maven:
```bash
git clone https://github.com/Ramin2005/Matrix-Determinant.git
cd Matrix-Determinant
mvn -q -DskipTests package
```

Run (example JAR path may differ):
```bash
java -jar build/libs/matrix-determinant-all.jar --help
```

## Command-Line Usage
Basic usage:
```bash
# From a file (CSV or whitespace-separated)
java -jar matrix-determinant.jar --input matrix.txt

# From STDIN
cat matrix.csv | java -jar matrix-determinant.jar

# Specify method (gauss | lu | laplace | sarrus)
java -jar matrix-determinant.jar --method lu --input matrix.txt
```

Common flags:
- `--input <path>`: Path to matrix file; if omitted, reads from STDIN
- `--method <name>`: Algorithm to use; default is `gauss`
- `--precision <double|bigdecimal>`: Numeric mode (if supported); default `double`
- `--delimiter <auto|space|comma>`: Input delimiter handling
- `--help`: Show usage

> TODO: Update the flag names to match the actual CLI.

Exit codes:
- 0: Success
- 1: Invalid input (non-square, parse failure)
- 2: Internal error

## Library Usage
Add as a module dependency (local project) or include the built JAR on your classpath.

Example (replace package and class names to match the code):

```java
// TODO: Replace with the real package
import com.example.matrix.DeterminantCalculator;
import com.example.matrix.Method;

public class Demo {
  public static void main(String[] args) {
    double[][] A = {
      {4, 2, 1},
      {0, 3, -1},
      {2, -2, 5}
    };

    DeterminantCalculator calc = new DeterminantCalculator()
        .withMethod(Method.LU)          // or Method.GAUSS, Method.LAPLACE, Method.SARRUS
        .withPivoting(true);            // if applicable

    double det = calc.determinant(A);
    System.out.println("det(A) = " + det);
  }
}
```

If a convenience static method exists:
```java
double det = DeterminantCalculator.det(A); // TODO: adjust to actual API
```

## Algorithms
- Gaussian Elimination (default)
  - Partial pivoting for stability
  - Complexity: O(n³)
- LU Decomposition
  - Doolittle or Crout variants
  - Complexity: O(n³)
- Laplace Expansion (Cofactor)
  - Only for very small n (e.g., n ≤ 5) due to factorial growth
- Sarrus Rule
  - For 3×3 matrices only

Method selection guidelines:
- n ≥ 6: prefer `gauss` or `lu`
- n = 3: `sarrus` is fastest
- n ≤ 5: `laplace` possible for demonstration only

## Precision and Stability
- Default numeric type: `double`
- Pivoting: Enabled for `gauss`/`lu` if implemented
- Tolerance: small pivot threshold (e.g., 1e-12) to detect near‑singular matrices
- BigDecimal mode (if supported): Use `--precision bigdecimal` for higher precision at a performance cost

> TODO: Confirm whether BigDecimal mode exists and document scale/MathContext.

## Input Formats
- CSV (comma-separated)
- Whitespace-separated (spaces or tabs)
- Square matrix required; all rows must have the same number of columns

Examples:
```
# whitespace
1 2 3
4 5 6
7 8 9
```

```
# csv
1,2,3
0,1,4
5,6,0
```

## Examples
2×2:
```
A = [ [a, b],
      [c, d] ]

det(A) = ad - bc
```

3×3 (sample):
```
1 2 3
0 1 4
5 6 0
```
Command:
```bash
java -jar matrix-determinant.jar --input examples/3x3.csv
```
Expected:
```
det(A) = 1*(1*0 - 4*6) - 2*(0*0 - 4*5) + 3*(0*6 - 1*5) = -24 + 40 - 15 = 1
```

## Testing
Gradle:
```bash
./gradlew test
```

Maven:
```bash
mvn test
```

> TODO: If you have property-based tests or fuzz tests, document them here.

## Project Structure
```
Matrix-Determinant/
├─ src/
│  ├─ main/
│  │  └─ java/
│  │     └─ TODO/your/package/  # e.g., ramin/matrix
│  │        ├─ DeterminantCalculator.java
│  │        ├─ Methods.java
│  │        └─ Main.java         # CLI entry point
│  └─ test/
│     └─ java/
│        └─ TODO/your/package/
│           └─ DeterminantCalculatorTest.java
├─ build.gradle or pom.xml
└─ README.md
```

> TODO: Update file and class names to match the repo.

## Performance Notes
- Elimination/LU: O(n³) time, O(n²) memory
- Laplace: O(n!) time; only for very small n (educational)
- Numerical stability depends on pivoting and scaling; conditioning of the matrix affects accuracy

## Roadmap
- Optional BigDecimal path for high‑precision calculations
- Sparse matrix optimizations (if needed)
- Simple matrix file formats (Matrix Market) support
- Benchmarks and profiling reports
- GitHub Actions CI for tests

## License
TODO: Add your license. If none, consider MIT:

```
MIT License
Copyright (c) 2025 ...

Permission is hereby granted, free of charge, to any person obtaining a copy...
```
