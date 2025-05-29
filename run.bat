@echo off
echo Discrete Probability Distributions Calculator
echo ============================================
echo.

echo Compiling Java application...
javac DiscreteDistributionCalculator.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo.
    echo Starting application...
    java DiscreteDistributionCalculator
) else (
    echo Compilation failed! Please check for errors.
    pause
) 