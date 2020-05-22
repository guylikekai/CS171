public class MyStackDynamic implements MyStackDefinition{
    private String[] a;
    private int N;
    private int capacity;

    public MyStackDynamic(int capacity){
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

    //TODO: alter this method to increase capacity when needed
    public void push(String e){
        if(isFull()){
            resize(capacity*2);
            a[N++] = e;
        }
        else{
            a[N++] = e;
        }
    }

    //TODO: alter this method to decrease capacity when needed
    public String pop(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return "";
        }
        else{
            String e = a[--N];
            a[N] = null;
            if (N <= capacity/4) {
                resize(capacity/2); //halve the array if 1/4 full
            }
            return e;
        }
    }

    public String top(){
        if(!a.isEmpty()){
            return a[N-1];
        }
        return "";
    }

    //TODO: write a method to resize the array
    private void resize(int newCapacity) {
        String[] tempArray = new String[newCapacity];

        for (int i = 0; i < N; i ++) {
            tempArray[i] = a[i];
        }

        a = tempArray;
        capacity = newCapacity;
    }
}
