public class StackTrace {

    public static void main(String[] args) {
        a();
    }

    static void a() {
        b();
    }

    static void b() {
        c();
    }

    static void c() {
        d();
    }

    static void d() {
        throw new NullPointerException();
    }
}


