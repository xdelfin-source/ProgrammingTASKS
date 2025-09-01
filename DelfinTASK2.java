
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) { // I used a while loop to keep the program running until the user chooses to exit or to stop
            System.out.println("\n Please enter your choice:");
            System.out.println("1. Trigonometric Function Calculator");
            System.out.println("2. Angle Quadratic Function Calculator");
            System.out.println("3. Right Triangle Solver");
            System.out.println("4. Trigonometric Identity Verifier");
            System.out.println("5. Wave Properties Analyzer");
            System.out.println("6. Exit program");
            System.out.println("Please select a problem to run: ");

            try {// I also used a try-catch block to "catch" any errors. Its basically a "plan B" of some sort because if an error occurs, instead of crashing, the program looks for another way to execute that code
                int choice = scanner.nextInt();
                if (choice == 1) {
                    problem1TrigoFuncCal();

                } else if (choice == 2) {
                    problem2AngleQFC();
                } else if (choice == 3) {
                    problem2AngleQFC();
                } else if (choice == 4) {
                    problem2AngleQFC();
                } else if (choice == 5) {
                    problem2AngleQFC();
                } else if (choice == 6) {
                    problem2AngleQFC();
                    running = false;
                    System.out.println("Bye!");
                }
            } catch (InputMismatchException e) {// The program detects an illegal input, like a letter or character for example. since its on a loop, this will notify the user and then they can choose again.
                System.out.println("\nInvalid input. Please enter a number");
                scanner.next();
            }
        }
    }

    // problem 1
    public static void problem1TrigoFuncCal() {
        System.out.println("\n[Trigonometric Function Calculator]");
        System.out.println("\nPlease enter an angle in degrees: ");
        double degrees = scanner.nextDouble();
        //converts the angle into radians
        double radians = Math.toRadians(degrees);

        System.out.println("Chose a Function to calculate the angle from: ");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent ");
        System.out.println("4. All three");
        System.out.println("Enter your choice from 1-4: ");
        int choice = scanner.nextInt();

        boolean b = Math.abs(degrees % 180 - 90) < 1 || Math.abs(degrees % 180 - 270) < 1;//checks for tangent undefined values
        if (choice == 1) {
            System.out.printf("sin of %.2f degrees is: %.4f%n", degrees, Math.sin(radians));

        } else if (choice == 2) {
            System.out.printf("cos of %.2f degrees is: %.4f%n", degrees, Math.cos(radians));

        } else if (choice == 3) {
            if (b) {
                System.out.println("Warning! Tangent is undefined for angles close to 90deg or 270deg");
            } else {
                System.out.printf("tan of %.2f degrees is: %.4f%n", degrees, Math.tan(radians));
            }

        } else if (choice == 4) {
            System.out.printf("sin of %.2f degrees is: %.4f%n", degrees, Math.sin(radians));
            System.out.printf("cos of %.2f degrees is: %.4f%n", degrees, Math.cos(radians));
            if (b) {
                System.out.println("Warning! Tangent is undefined for angles close to 90deg or 270deg");
            } else {
                System.out.printf("tan of %.2f degrees is: %.4f%n", degrees, Math.tan(radians));
            }
        } else {
            System.out.println("Invalid choice.");

            //Java's trigonometric functions work with radians, not in degrees, so by converting the angles into radians the functions will correctly execute as its in its standard unit.
            //the tangent becomes undefined because the value of the cosine is zero at those points.
            //you can add new options to the menu to include reciprocal functions
        }
    }

    // problem 2
    public static void problem2AngleQFC() {

        System.out.println("\n[Angle Quadrant Detector]");
        System.out.println("\nEnter an angle in degrees: ");
        double degrees = scanner.nextDouble();
//normalize the angle to be between 0 and 360
        double normalizedAngle = degrees % 360;
        if (normalizedAngle < 0) {
            normalizedAngle += 360;
        }
        System.out.printf("normalized angle is: %.2f*\n", normalizedAngle);

        String quadrant;
        String sinSign, cosSign, tanSign;
// this part determines the quadrant and the sign of each trigo. functions
        // based on the "All Students Take Calculus"
        if (normalizedAngle > 0 && normalizedAngle < 90) {
            quadrant = "Quadrant I";
            sinSign = "Positive";
            cosSign = "Positive";
            tanSign = "Positive";
        } else if (normalizedAngle > 90 && normalizedAngle < 180) {
            quadrant = "Quadrant II";
            sinSign = "Positive";
            cosSign = "Negative";
            tanSign = "Negative";
        } else if (normalizedAngle > 180 && normalizedAngle < 270) {
            quadrant = "Quadrant III";
            sinSign = "Negative";
            cosSign = "Negative";
            tanSign = "Positive";
        } else if (normalizedAngle > 270 && normalizedAngle < 360) {
            quadrant = "Quadrant IV";
            sinSign = "Negative";
            cosSign = "Positive";
            tanSign = "Negative";
        } else {
            if (normalizedAngle == 0 || normalizedAngle == 360) {
                quadrant = "Postive X-axis";
                sinSign = "Zero";
                cosSign = "Postive";
                tanSign = "Zero";
            } else if (normalizedAngle == 90) {
                quadrant = "Positive Y-axis";
                sinSign = "Positive";
                cosSign = "Zero";
                tanSign = "Undefined";
            } else if (normalizedAngle != 180) { // normalizedAngle == 270)
                quadrant = "Negative Y-axis";
                sinSign = "Negative";
                cosSign = "Zero";
                tanSign = "Undefined";
            } else {
                quadrant = "Negative X-axis";
                sinSign = "Zero";
                cosSign = "Negative";
                tanSign = "Zero";
            }
        }
        System.out.println("The angle is in the " + quadrant + ".");
        System.out.println("Sine is " + sinSign);
        System.out.println("Cosine is " + cosSign);
        System.out.println("Tangent is " + tanSign);

        //normalizing angles is important because it simplifies the process of determining what quadrant it is.
        // the sign changes depending on what quadrant its located
        // the angles that fall exactly on the axes (0, 90, 180, and 270) do not belong to a quadrant and require special handling
    }

    // problem 3 solves for the missing elements of a right triangle
    public static void problem3RightTriangle() {
        System.out.println("\n[Right Triangle Solver]");
        System.out.println("What element of a triangle do you know?");
        System.out.println("1. Two sides");
        System.out.println("2. One side and one angle");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        double sideA = 0, sideB = 0, sideC = 0;
        double angleA = 0, angleB = 0;

        if (choice == 1) {
            System.out.println("Which two sides do you know?");
            System.out.println("1. Side A (Opposite) and Side B (Adjacent)");
            System.out.println("2. Side A (Opposite) and Side C (Hypotenuse)");
            System.out.println("3. Side B (Adjacent) and Side C (Hypotenuse)");
            System.out.print("Enter your choice (1-3): ");
            int sideChoice = scanner.nextInt();

            if (sideChoice == 1) {
                System.out.print("Enter Side A: ");
                sideA = scanner.nextDouble();
                System.out.print("Enter Side B: ");
                sideB = scanner.nextDouble();
                sideC = Math.sqrt(sideA * sideA + sideB * sideB);
                angleA = Math.toDegrees(Math.atan2(sideA, sideB));
                angleB = 90 - angleA;
            } else if (sideChoice == 2) {
                System.out.print("Enter Side A: ");
                sideA = scanner.nextDouble();
                System.out.print("Enter Side C (Hypotenuse): ");
                sideC = scanner.nextDouble();
                sideB = Math.sqrt(sideC * sideC - sideA * sideA);
                angleA = Math.toDegrees(Math.asin(sideA / sideC));
                angleB = 90 - angleA;
            } else if (sideChoice == 3) {
                System.out.print("Enter Side B: ");
                sideB = scanner.nextDouble();
                System.out.print("Enter Side C (Hypotenuse): ");
                sideC = scanner.nextDouble();
                sideA = Math.sqrt(sideC * sideC - sideB * sideB);
                angleB = Math.toDegrees(Math.asin(sideB / sideC));
                angleA = 90 - angleB;
            }
        } else if (choice == 2) {
            System.out.print("Enter the known angle (in degrees, not 90°): ");
            double knownAngle = scanner.nextDouble();
            if (knownAngle >= 90) {
                System.out.println("Invalid angle. Must be less than 90°.");
                return;
            }

            System.out.println("Which side do you know?");
            System.out.println("1. Side A (Opposite)");
            System.out.println("2. Side B (Adjacent)");
            System.out.println("3. Side C (Hypotenuse)");
            System.out.print("Enter your choice (1-3): ");
            int sideChoice = scanner.nextInt();

            double knownAngleRadians = Math.toRadians(knownAngle);
            if (sideChoice == 1) {
                System.out.print("Enter Side A: ");
                sideA = scanner.nextDouble();
                sideB = sideA / Math.tan(knownAngleRadians);
                sideC = sideA / Math.sin(knownAngleRadians);
                angleA = knownAngle;
                angleB = 90 - knownAngle;
            } else if (sideChoice == 2) {
                System.out.print("Enter Side B: ");
                sideB = scanner.nextDouble();
                sideA = sideB * Math.tan(knownAngleRadians);
                sideC = sideB / Math.cos(knownAngleRadians);
                angleA = knownAngle;
                angleB = 90 - knownAngle;
            } else if (sideChoice == 3) {
                System.out.print("Enter Side C: ");
                sideC = scanner.nextDouble();
                sideA = sideC * Math.sin(knownAngleRadians);
                sideB = sideC * Math.cos(knownAngleRadians);
                angleA = knownAngle;
                angleB = 90 - knownAngle;
            }
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
            return;
        }

        // Display results with validation
        if (sideA > 0 && sideB > 0 && sideC > 0) {
            System.out.println("\n--- Right Triangle Solution ---");
            System.out.printf("Side A: %.4f\n", sideA);
            System.out.printf("Side B: %.4f\n", sideB);
            System.out.printf("Side C: %.4f\n", sideC);
            System.out.println("--- Angles ---");
            System.out.printf("Angle A (Opposite A): %.2f°\n", angleA);
            System.out.printf("Angle B (Opposite B): %.2f°\n", angleB);
            System.out.print("Angle C (Right Angle): 90.00°\n");
            System.out.println("--- Area ---");
            System.out.printf("Area: %.4f\n", 0.5 * sideA * sideB);
        } else {
            System.out.println("An error occurred. Please ensure all inputs are positive and valid.");

            //Validating that the angles in a right triangle are less than 90 deg because it is impossible for either of the two angle to be equal or greater than 90 since the sum of all angle is 180
            // the program handles different types of known values by using a main if-else if structure.
            //if the values entered cannot form a right triangle then an error message will print out
        }
    }

//problem 4 verifies commmon trigo. identities for a given angle
    public static void problem4TrigoIdentityVerify() {
        System.out.println("\n [Trigonometric Identity Verifier]");
        System.out.print("Enter an angle in degrees: ");
        double degrees = scanner.nextDouble();
        double radians = Math.toRadians(degrees);
        double tolerance = 1e-9;

        double sinTheta = Math.sin(radians);
        double cosTheta = Math.cos(radians);
        double tanTheta = Math.tan(radians);
// Identity 1: sin²θ + cos²θ = 1
        double leftSide1 = sinTheta * sinTheta + cosTheta * cosTheta;
        System.out.printf("\nVerifying sin²θ + cos²θ = 1\n");
        System.out.printf("Left side: %.10f\n", leftSide1);
        System.out.printf("Right side: 1.0\n");
        if (Math.abs(leftSide1 - 1.0) < tolerance) {
            System.out.println("Identity holds true.");
        } else {
            System.out.printf("Identity does not hold. Difference: %.10f\n", Math.abs(leftSide1 - 1.0));
        }

        // Identity 2: 1 + tan²θ = sec²θ
        if (Math.abs(degrees % 180 - 90) < 1) {
            System.out.println("\nVerifying 1 + tan²θ = sec²θ");
            System.out.println("Identity is undefined for angles near 90° and 270°.");
        } else {
            double secTheta = 1.0 / cosTheta;
            double leftSide2 = 1 + tanTheta * tanTheta;
            double rightSide2 = secTheta * secTheta;
            System.out.printf("\nVerifying 1 + tan²θ = sec²θ\n");
            System.out.printf("Left side: %.10f\n", leftSide2);
            System.out.printf("Right side: %.10f\n", rightSide2);
            if (Math.abs(leftSide2 - rightSide2) < tolerance) {
                System.out.println("Identity holds true.");
            } else {
                System.out.printf("Identity does not hold. Difference: %.10f\n", Math.abs(leftSide2 - rightSide2));
            }
        }

        // Identity 3: sin(2θ) = 2sinθcosθ
        double leftSide3 = Math.sin(2 * radians);
        double rightSide3 = 2 * sinTheta * cosTheta;
        System.out.printf("\nVerifying sin(2θ) = 2sinθcosθ\n");
        System.out.printf("Left side: %.10f\n", leftSide3);
        System.out.printf("Right side: %.10f\n", rightSide3);
        if (Math.abs(leftSide3 - rightSide3) < tolerance) {
            System.out.println("Identity holds true.");
        } else {
            System.out.printf("Identity does not hold. Difference: %.10f\n", Math.abs(leftSide3 - rightSide3));

            //it is necessary to use tolerance when comparing floating-point because computers cant always represent decimal numbers with perfect accuracy.
            // the identity 2. 1 + tan²θ = sec²θ is the most susceptible to floating-point precision issues in the program
            //I can extend it by adding more case statements to the switch and increasing the tolerance if necessary to account for the increased potential for floating-point errors
        }
    }

//problem 5
    public static void problem5WaveProperties() {
        System.out.println("\n [Wave Properties Analyzer]");

        System.out.print("Enter Amplitude (A): ");
        double amplitude = scanner.nextDouble();
        System.out.print("Enter Frequency (f) in Hz: ");
        double frequency = scanner.nextDouble();
        System.out.print("Enter Phase Shift (phi) in degrees: ");
        double phaseShiftDegrees = scanner.nextDouble();
        System.out.print("Enter a time value (t) in seconds: ");
        double time = scanner.nextDouble();

        double phaseShiftRadians = Math.toRadians(phaseShiftDegrees);

        // Equation for a sinusoidal wave: y(t) = A * sin(2*pi*f*t + phi)
        double value = amplitude * Math.sin(2 * Math.PI * frequency * time + phaseShiftRadians);
        double period = 1.0 / frequency;

        System.out.printf("\nInstantaneous value at t=%.2f s: %.4f\n", time, value);

        // Determine if it's a peak, trough, or zero-crossing
        // Use a small tolerance for floating-point comparison
        double tolerance = 1e-6;
        if (Math.abs(value - amplitude) < tolerance) {
            System.out.println("The wave is at a peak.");
        } else if (Math.abs(value - (-amplitude)) < tolerance) {
            System.out.println("The wave is at a trough.");
        } else if (Math.abs(value) < tolerance) {
            System.out.println("The wave is at a zero-crossing.");
        } else {
            System.out.println("The wave is at an intermediate point.");
        }

        // Calculate the next time the wave will reach a peak
        // The sine function reaches its peak (1) when its argument is PI/2, 5PI/2, etc.
        double argument = 2 * Math.PI * frequency * time + phaseShiftRadians;
        double nextPeakArgument = Math.ceil((argument - Math.PI / 2) / (2 * Math.PI)) * 2 * Math.PI + Math.PI / 2;
        double nextPeakTime = (nextPeakArgument - phaseShiftRadians) / (2 * Math.PI * frequency);

        System.out.printf("The next peak will occur at approximately t=%.4f s\n", nextPeakTime);

        // the program determines if the wave is at a peak or trough by comparing its instantaneous value to its amplitude
        // It finds the time of the next peak by working with the argument of the sine function 2πft+ϕ). A sinusoidal wave reaches its peak when this argument is equal to pi over 2 plus any even multiple of pi
        //I would need to add new functions to create new methods for each type of wave. Each method would contain the specific mathematical formula for that wave type.
    }
}
