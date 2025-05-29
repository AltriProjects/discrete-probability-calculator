#!/bin/bash

echo "Discrete Probability Distributions Calculator"
echo "============================================"
echo

echo "Compiling Java application..."
javac DiscreteDistributionCalculator.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo
    echo "Starting application..."
    java DiscreteDistributionCalculator
else
    echo "Compilation failed! Please check for errors."
    read -p "Press Enter to continue..."
fi 