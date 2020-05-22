public class MyStack implements MyStackDefinition{
    private String[] a;
    private int N;
    private int capacity;

    public MyStack(int capacity){
        this.capacity = capacity;
        N=0;
        a = new String[this.capacity];
    }

    public boolean isEmpty(){
        return (N==0);
    }

    public boolean isFull(){
        return (N == this.capacity);
    }

    public void push(String e){
        if(isFull()){
            System.out.println("Stack capacity reached! Cannot push element.");
        }
        else{
            a[N++] = e;
            // a[N] = e;
            // N++;
        }
    }

    public String pop(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return "";
        }
        else{
            String e = a[--N];
            a[N] = null;
            return e;
        }
    }

    public String top(){
        return a[N-1];
    }
}