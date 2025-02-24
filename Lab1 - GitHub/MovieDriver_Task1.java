import java.util.Scanner;

public class MovieDriver {
    public static void main(String[] args) {

        boolean anotherMovie = false;
        boolean validInput = false;
        Scanner input = new Scanner(System.in);

        Movie movie = new Movie();


            System.out.print("Enter the title of a movie: ");
            movie.setTitle(input.nextLine());

            System.out.print("Enter the movies rating: ");
            movie.setRating(input.nextLine());

            System.out.print("Enter the number of tickets sold: ");
            movie.setSoldTickets(input.nextInt());
            input.nextLine();

            System.out.println(movie.toString());


        System.out.println("Goodbye");




    }
}
