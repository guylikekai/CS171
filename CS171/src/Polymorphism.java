// INSTRUCTIONS:
// 1. Try to compile the following code. 
//    You should get compiler errors. Where is the first error?
//    Line 20: ClassB x1 = new ClassA
//    Why is this an error? Comment out the line causing the error.
//    ClassB is an instance of ClassA not the other way around (Liskov Substitution Principle)
// 2. Try to compile the code again.
//    You should get another compiler error. Where is this error?
//    Line 23: x.method3()
//    Why is this an error? Comment out the line causing the error.
//    x is an instance of ClassA so it contains the methods in ClassA and method3 is a new method in ClassB
// 3. Now the code should compile. Before you run it, hypothesize
//    about the following lines of code:
//    a. Which method1 (of ClassA or ClassB) will be called in line 25?
//    ClassB
//    b. What will be printed in lines 30-32, lines 36-38, and lines 42-44?
//    true
//    false
//    false
//    true
//    true
//    false
//    true
//    true
//    true
// 4. Run the code. Do the results match your expectations?
//    Yes they do
//    If not, make sure you understand why.
// Submit your answers to 1-4 in the text of the assignment 
//   "Polymorphism Activity" on Canvas.

public class Polymorphism{
    public static void main(String[] args){
        ClassA x = new ClassB();
        //ClassB x1 = new ClassA();   This is an error because ClassB is an instance of ClassA not the other way around

        x.method2();
        //x.method3();  This is an error because method3 is declared in ClassB which is an instance of ClassA

        x.method1(); //which is executed? ClassB because Override and it is a new object of ClassB

        // what is printed in the following lines?
        ClassA a = new ClassA();

        System.out.println(a instanceof ClassA); //True
        System.out.println(a instanceof ClassB); //False
        System.out.println(a instanceof ClassC); //False

        ClassB b = new ClassB();

        System.out.println(b instanceof ClassA); //True
        System.out.println(b instanceof ClassB); //True
        System.out.println(b instanceof ClassC); //False

        ClassC c = new ClassC();

        System.out.println(c instanceof ClassA); //True
        System.out.println(c instanceof ClassB); //True
        System.out.println(c instanceof ClassC); //True
    }

    private static class ClassA{
        public void method1(){
            System.out.println("method1 of ClassA");
        }

        public void method2(){
            System.out.println("method2 of ClassA");
        }
    }

    private static class ClassB extends ClassA{
        @Override
        public void method1(){
            System.out.println("method1 of ClassB");
        }

        public void method3(){
            System.out.println("method3 of ClassB [new method]");
        }
    }

    private static class ClassC extends ClassB{

    }
}