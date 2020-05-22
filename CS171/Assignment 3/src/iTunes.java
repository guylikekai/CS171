public class iTunes{

    public static void main(String[] args){

        // Sample testing code ...
        //Create new playlist pl
        Playlist pl = new Playlist();

        // Test for specific error throw when calling playlist backwards on empty list
        //pl.displayPlaylistBackward();

        // Test for specific error throw when calling delete methods on empty list
        //pl.deleteEveryMthEpisode(2);
        //pl.deleteEpisode("Hi");

        // Test for correctly adding node to empty list using addFirst
        /*pl.addFirst("PlanetMoney",26.0);
        System.out.println(pl.getSize());
        pl.displayPlaylistBackward();
        pl.displayPlaylistForward();
        */

        // Test for correctly adding node to nonempty list using addFirst
        /*
        pl.addFirst("HowIBuiltThis",10);
        pl.addFirst("EzraKleinShow",65.0);
        pl.addFirst("RadioLab",25.5);
        pl.displayPlaylistForward();
        pl.displayPlaylistBackward();
        */

        // Test for correctly adding to index 0 in empty list
        /*pl.add("Hi", 25, 0);
        pl.displayPlaylistForward();
        pl.displayPlaylistBackward();
        System.out.println(pl.getSize());
        pl.add("yo", 30, 0);
        pl.displayPlaylistForward();
        pl.displayPlaylistBackward();
        System.out.println(pl.getSize());
        pl.addFirst("MakeMeSmart",24.5);
        pl.addFirst("Worldly",55);
        pl.displayPlaylistForward();
        pl.displayPlaylistBackward();
        System.out.println(pl.getSize());
        pl.add("oooohhhh", 24, 4);
        pl.displayPlaylistForward();
        pl.displayPlaylistBackward();
        System.out.println(pl.getSize());
        pl.add("add two baby", 32, 2);
        pl.displayPlaylistForward();
        pl.displayPlaylistBackward();
        System.out.println(pl.getSize());
        */

        /*
        pl.displayPlaylistBackward();
        pl.displayPlaylistForward();
        /*

        pl.addFirst("MakeMeSmart",24.5);
        pl.addFirst("Worldly",55);
        pl.addFirst("ReplyAll",23.0);
        pl.displayPlaylistForward();
        pl.displayPlaylistBackward();
        System.out.println(pl.deleteEveryMthEpisode(1));



        pl.addLast("Invisibilia",33.5);

        pl.displayPlaylistForward();
        pl.displayPlaylistBackward();

        //pl.deleteEveryMthEpisode(3);

        pl.displayPlaylistForward();
        pl.displayPlaylistBackward();


 */
        // Test for Josephus

        pl.addLast("1", 5);
        pl.addLast("2", 5);
        pl.addLast("3", 5);
        pl.addLast("4", 5);
        pl.addLast("5", 5);
        pl.addLast("6", 5);
        pl.addLast("7", 5);
        pl.addLast("8", 5);
        pl.addLast("9", 5);
        pl.addLast("10", 5);
        pl.addLast("11", 5);
        pl.addLast("12", 5);
        pl.addLast("13", 5);
        pl.addLast("14", 5);
        pl.addLast("15", 5);
        pl.addLast("16", 5);

        pl.displayPlaylistForward();
        System.out.println(pl.deleteEveryMthEpisode(13));
    }


}

