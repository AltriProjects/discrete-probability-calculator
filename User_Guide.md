# Discrete Probability Distributions Calculator
## User Guide

---

### Table of Contents
1. [Introduction](#1-introduction)
2. [System Requirements](#2-system-requirements)
3. [Installation and Setup](#3-installation-and-setup)
4. [Getting Started](#4-getting-started)
5. [Distribution Types and Usage](#5-distribution-types-and-usage)
6. [User Interface Guide](#6-user-interface-guide)
7. [Step-by-Step Tutorial](#7-step-by-step-tutorial)
8. [Interpreting Results](#8-interpreting-results)
9. [Error Handling](#9-error-handling)
10. [Troubleshooting](#10-troubleshooting)
11. [Mathematical Background](#11-mathematical-background)
12. [Appendix](#12-appendix)

---

## 1. Introduction

The Discrete Probability Distributions Calculator is a modern Java-based GUI application designed to compute various discrete probability distributions commonly used in statistics and probability theory. This tool provides an intuitive interface for students, researchers, and professionals to calculate probability mass functions (PMF), cumulative distribution functions (CDF), and statistical measures.

### Purpose
This application serves as an educational and professional tool for:
- Understanding discrete probability distributions
- Performing accurate statistical calculations
- Visualizing probability concepts through clear results
- Supporting coursework in probability and statistics

### Key Features
- **Four Distribution Types**: Binomial, Poisson, Geometric, and Hypergeometric
- **Comprehensive Calculations**: PMF, CDF, mean, variance, and standard deviation
- **Modern User Interface**: Clean, professional design with intuitive controls
- **Input Validation**: Prevents invalid parameter entries
- **Error Handling**: Clear error messages for incorrect inputs
- **Responsive Design**: Adapts to different content lengths

### Development Team
- Christian Oliver Obrero
- John Keano Del Rosario
- [John Paul Caigas](https://github.com/mra1k3r0/)

---

## 2. System Requirements

### Minimum Requirements
- **Operating System**: Windows 7/8/10/11, macOS 10.12+, or Linux (Ubuntu 18.04+)
- **Java Version**: Java 8 (JRE 1.8) or higher
- **Memory**: 512 MB RAM minimum
- **Storage**: 50 MB available disk space
- **Display**: 1024×768 resolution minimum

### Recommended Requirements
- **Java Version**: Java 11 or higher
- **Memory**: 1 GB RAM or more
- **Display**: 1280×720 resolution or higher for optimal viewing

### Required Software
- Java Runtime Environment (JRE) 8 or higher
- No additional libraries or dependencies required

---

## 3. Installation and Setup

### Step 1: Verify Java Installation
1. Open Command Prompt (Windows) or Terminal (macOS/Linux)
2. Type: `java -version`
3. Ensure Java 8 or higher is installed
4. If not installed, download from [Oracle's website](https://www.oracle.com/java/technologies/downloads/)

### Step 2: Download Application Files
Ensure you have the following files:
- `DiscreteDistributionCalculator.java` (source code)
- `run.bat` (Windows launcher)
- `run.sh` (Linux/Mac launcher)

### Step 3: Compilation (if needed)
If you only have the source code:
```bash
javac DiscreteDistributionCalculator.java
```

### Step 4: Running the Application

#### Windows:
- Double-click `run.bat`, or
- Open Command Prompt in the application folder
- Type: `java DiscreteDistributionCalculator`

#### macOS/Linux:
- Open Terminal in the application folder
- Type: `./run.sh`, or
- Type: `java DiscreteDistributionCalculator`

---

## 4. Getting Started

### First Launch
1. **Start the application** using one of the methods above
2. **Application window** will open with the title "Discrete Probability Calculator"
3. **Default view** shows Binomial Distribution parameters
4. **Interface components**:
   - Header with title and distribution selector
   - Parameters panel on the left
   - Results panel on the right
   - Calculate and Clear buttons

### Basic Workflow
1. **Select** a distribution type from the dropdown menu
2. **Enter** the required parameters in the input fields
3. **Click** the "Calculate" button
4. **Review** the results in the right panel
5. **Clear** inputs using the "Clear" button if needed

---

## 5. Distribution Types and Usage

### 5.1 Binomial Distribution

**When to Use:**
- Fixed number of independent trials
- Each trial has only two outcomes (success/failure)
- Constant probability of success across trials
- Trials are independent

**Parameters:**
- **n (number of trials)**: Total number of trials (positive integer)
- **p (probability of success)**: Probability of success on each trial (0 ≤ p ≤ 1)
- **k (number of successes)**: Number of successes to calculate probability for

**Example Applications:**
- Coin flipping experiments
- Quality control testing
- Medical treatment success rates
- Survey response analysis

**Sample Calculation:**
- n = 10 (flip coin 10 times)
- p = 0.5 (fair coin)
- k = 6 (exactly 6 heads)

### 5.2 Poisson Distribution

**When to Use:**
- Counting events in a fixed interval
- Events occur independently
- Average rate of occurrence is constant
- Events are rare relative to the interval

**Parameters:**
- **λ (average rate)**: Average number of events per interval (λ > 0)
- **k (events)**: Number of events to calculate probability for

**Example Applications:**
- Customer arrivals per hour
- Defects per manufacturing batch
- Phone calls per minute
- Accidents per month

**Sample Calculation:**
- λ = 3.5 (average customers per hour)
- k = 5 (exactly 5 customers)

### 5.3 Geometric Distribution

**When to Use:**
- Finding the trial number of the first success
- Independent trials with constant success probability
- Modeling "waiting time" until first success

**Parameters:**
- **p (probability of success)**: Probability of success on each trial (0 < p ≤ 1)
- **k (trial)**: Trial number of first success

**Example Applications:**
- Rolling dice until first six
- Sales calls until first sale
- Testing until first defect
- Job interviews until first offer

**Sample Calculation:**
- p = 1/6 ≈ 0.167 (rolling a six)
- k = 3 (first six on 3rd roll)

### 5.4 Hypergeometric Distribution

**When to Use:**
- Sampling without replacement from finite population
- Population contains two types of objects
- Interested in number of specific type in sample

**Parameters:**
- **N (population size)**: Total population size
- **K (success states in population)**: Number of success items in population
- **n (draws)**: Number of items drawn from population
- **k (observed successes)**: Number of success items in sample

**Example Applications:**
- Drawing cards from a deck
- Quality inspection sampling
- Survey sampling
- Lottery calculations

**Sample Calculation:**
- N = 52 (deck of cards)
- K = 13 (hearts in deck)
- n = 5 (cards drawn)
- k = 2 (exactly 2 hearts)

---

## 6. User Interface Guide

### 6.1 Main Window Components

#### Header Section
- **Title**: "Discrete Probability Calculator"
- **Distribution Selector**: Dropdown menu for choosing distribution type
- **Clean Design**: Professional typography and spacing

#### Parameters Panel (Left Side)
- **Dynamic Fields**: Input fields change based on selected distribution
- **Clear Labels**: Descriptive parameter names with explanations
- **Modern Styling**: Clean borders and proper spacing
- **Input Validation**: Real-time validation feedback

#### Results Panel (Right Side)
- **Formatted Output**: Professional formatting with icons
- **Scroll Support**: Automatic scrollbars when content is long
- **Monospace Font**: Easy-to-read numerical results
- **Color-Coded Sections**: Different sections clearly distinguished

#### Button Panel
- **Calculate Button**: Blue button for performing calculations
- **Clear Button**: Red button for clearing inputs and results
- **Hover Effects**: Visual feedback on mouse interaction

### 6.2 Color Scheme and Design

#### Professional Color Palette
- **Primary Blue**: #636EF1 (main actions)
- **Emerald Green**: #10B981 (secondary elements)
- **Red**: #EF4444 (clear/delete actions)
- **Light Gray**: #F9FAFB (background)
- **White**: #FFFFFF (cards and panels)
- **Dark Gray**: #111827 (primary text)

#### Typography
- **Headers**: Segoe UI Bold, 24px
- **Labels**: Segoe UI Regular, 13-14px
- **Results**: JetBrains Mono, 13px (monospace for numbers)

---

## 7. Step-by-Step Tutorial

### Tutorial 1: Binomial Distribution Calculation

**Scenario**: Calculate the probability of getting exactly 6 heads in 10 coin flips.

1. **Launch** the application
2. **Select** "Binomial Distribution" from the dropdown (default selection)
3. **Enter Parameters**:
   - n (number of trials): `10`
   - p (probability of success): `0.5`
   - k (number of successes): `6`
4. **Click** the "Calculate" button
5. **Review Results**:
   - P(X = 6) ≈ 0.205078
   - P(X ≤ 6) ≈ 0.828125
   - Expected Value (μ) = 5.0
   - Variance (σ²) = 2.5

### Tutorial 2: Poisson Distribution Calculation

**Scenario**: A call center receives an average of 4 calls per hour. What's the probability of receiving exactly 3 calls in the next hour?

1. **Select** "Poisson Distribution" from dropdown
2. **Enter Parameters**:
   - λ (average rate): `4`
   - k (events): `3`
3. **Click** "Calculate"
4. **Interpret Results**:
   - P(X = 3) ≈ 0.195367
   - P(X ≤ 3) ≈ 0.433470
   - Expected Value = 4.0

### Tutorial 3: Geometric Distribution Calculation

**Scenario**: What's the probability that the first six appears on the 4th roll of a die?

1. **Select** "Geometric Distribution"
2. **Enter Parameters**:
   - p (probability): `0.166667` (1/6)
   - k (trial): `4`
3. **Click** "Calculate"
4. **Review Results**:
   - P(X = 4) ≈ 0.096451
   - Expected Value ≈ 6.0

### Tutorial 4: Hypergeometric Distribution Calculation

**Scenario**: In a deck of 52 cards with 13 hearts, if you draw 5 cards, what's the probability of getting exactly 2 hearts?

1. **Select** "Hypergeometric Distribution"
2. **Enter Parameters**:
   - N (population size): `52`
   - K (success states): `13`
   - n (draws): `5`
   - k (observed successes): `2`
3. **Click** "Calculate"
4. **Analyze Results**:
   - P(X = 2) ≈ 0.274405
   - P(X ≤ 2) ≈ 0.900104

---

## 8. Interpreting Results

### 8.1 Result Sections

#### Distribution Header
- Shows the selected distribution type
- Confirms which calculation was performed

#### Parameters Section
- Lists all input parameters
- Useful for verification and documentation

#### Probability Results
- **P(X = k)**: Exact probability of getting k successes
- **P(X ≤ k)**: Probability of getting k or fewer successes
- **P(X > k)**: Probability of getting more than k successes

#### Statistical Measures
- **Expected Value (μ)**: Average outcome over many trials
- **Variance (σ²)**: Measure of spread in the distribution
- **Standard Deviation (σ)**: Square root of variance, same units as mean

### 8.2 Understanding Probability Values

#### Probability Interpretation
- **0.0**: Impossible event
- **0.5**: Equally likely to occur or not occur
- **1.0**: Certain event
- **Values close to 0**: Unlikely events
- **Values close to 1**: Very likely events

#### Using CDF Values
- **P(X ≤ k)**: Useful for "at most k" questions
- **P(X > k)**: Useful for "more than k" questions
- **P(X ≥ k)**: Calculate as 1 - P(X ≤ k-1)

---

## 9. Error Handling

### 9.1 Common Input Errors

#### Invalid Parameter Ranges
- **Binomial**: n ≤ 0, p < 0 or p > 1, k < 0 or k > n
- **Poisson**: λ ≤ 0, k < 0
- **Geometric**: p ≤ 0 or p > 1, k ≤ 0
- **Hypergeometric**: N ≤ 0, K < 0 or K > N, n ≤ 0 or n > N, k < 0 or k > min(n,K)

#### Non-Numeric Input
- Entering text instead of numbers
- Using commas instead of decimal points
- Empty fields when calculation is attempted

### 9.2 Error Messages

The application displays clear error messages in popup dialogs:
- **"Invalid parameters for [Distribution] distribution"**
- **"Error: [specific error description]"**

### 9.3 Error Prevention
- **Input Validation**: Real-time checking of parameter values
- **Clear Labels**: Descriptive field labels with value ranges
- **Example Values**: Documentation provides sample calculations

---

## 10. Troubleshooting

### 10.1 Application Won't Start

#### Check Java Installation
```bash
java -version
```
- Should show Java 8 or higher
- If not installed, download from Oracle website

#### Check File Permissions
- Ensure execute permissions on .sh files (Linux/Mac)
- Verify .class file exists and is not corrupted

#### Common Solutions
- Recompile: `javac DiscreteDistributionCalculator.java`
- Check working directory contains all files
- Try running directly: `java DiscreteDistributionCalculator`

### 10.2 Calculation Issues

#### Unexpected Results
- Verify parameter values are correct
- Check parameter ranges for the distribution
- Ensure using correct distribution for the problem

#### Mathematical Errors
- Very large factorials may cause overflow
- Use reasonable parameter values
- Check for typos in input values

### 10.3 Display Issues

#### Text Field Problems
- Clear the field and re-enter values
- Use decimal point (.) not comma (,)
- Avoid special characters

#### Results Not Showing
- Ensure all required parameters are filled
- Check for error messages
- Try clicking Calculate again

---

## 11. Mathematical Background

### 11.1 Probability Mass Function (PMF)

The PMF gives the probability that a discrete random variable equals a specific value.

#### Binomial PMF
P(X = k) = C(n,k) × p^k × (1-p)^(n-k)

Where C(n,k) = n! / (k!(n-k)!)

#### Poisson PMF
P(X = k) = (λ^k × e^(-λ)) / k!

#### Geometric PMF
P(X = k) = (1-p)^(k-1) × p

#### Hypergeometric PMF
P(X = k) = [C(K,k) × C(N-K,n-k)] / C(N,n)

### 11.2 Cumulative Distribution Function (CDF)

The CDF gives the probability that a random variable is less than or equal to a specific value.

CDF(k) = P(X ≤ k) = Σ PMF(i) for i = 0 to k

### 11.3 Statistical Measures

#### Expected Value (Mean)
- **Binomial**: μ = np
- **Poisson**: μ = λ
- **Geometric**: μ = 1/p
- **Hypergeometric**: μ = n(K/N)

#### Variance
- **Binomial**: σ² = np(1-p)
- **Poisson**: σ² = λ
- **Geometric**: σ² = (1-p)/p²
- **Hypergeometric**: σ² = n(K/N)(1-K/N)(N-n)/(N-1)

---

## 12. Appendix

### 12.1 Keyboard Shortcuts

- **Tab**: Navigate between input fields
- **Enter**: Activate Calculate button (when focused)
- **Escape**: Close error dialogs
- **Ctrl+A**: Select all text in focused field

### 12.2 File Structure

```
discrete-probability-calculator/
├── DiscreteDistributionCalculator.java    (Source code)
├── README.md                              (Project documentation)
├── User_Guide.md                          (This document)
├── run.bat                                (Windows launcher)
└── run.sh                                 (Linux/Mac launcher)
```

### 12.3 Version History

- **Version 1.0**: Initial release with all four distributions
- Modern UI implementation
- Comprehensive error handling
- Professional documentation

### 12.4 Technical Specifications

- **Programming Language**: Java
- **GUI Framework**: Swing
- **Minimum Java Version**: 8
- **Architecture**: Single-class desktop application
- **File Size**: Approximately 50KB compiled
- **Memory Usage**: < 100MB typical operation

### 12.5 Academic References

For theoretical background on discrete probability distributions, consult:
- Ross, S. (2019). A First Course in Probability
- Montgomery, D. C., & Runger, G. C. (2018). Applied Statistics and Probability for Engineers
- Walpole, R. E., et al. (2016). Probability & Statistics for Engineers & Scientists

---

**Document Version**: 0.3-alpha  
**Last Updated**: May 29, 2025  
**Prepared for**: ITA 225 - PROBABILITY AND STATISTICS IN INFORMATION TECHNOLOGY 