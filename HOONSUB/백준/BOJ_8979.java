import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        Country[] countries = new Country[N + 1];
        PriorityQueue<Country> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int number = Integer.parseInt(tokenizer.nextToken());
            int gold = Integer.parseInt(tokenizer.nextToken());
            int silver = Integer.parseInt(tokenizer.nextToken());
            int bronze = Integer.parseInt(tokenizer.nextToken());
            countries[number] = new Country(number, gold, silver, bronze);
            queue.add(countries[number]);
        }

        ArrayList<Country> rankedCountries = new ArrayList<>();
        while (!queue.isEmpty()) {
            Country country = queue.poll();

            if (rankedCountries.isEmpty()) {
                country.rank = 1;
                rankedCountries.add(country);
                continue;
            }

            Country beforeCountry = rankedCountries.get(rankedCountries.size() - 1);
            if (beforeCountry.compareTo(country) == 0) {
                country.rank = beforeCountry.rank;
            } else {
                country.rank = rankedCountries.size() + 1;
            }
            rankedCountries.add(country);
        }

        System.out.println(countries[K].rank);
    }
}

class Country implements Comparable<Country> {
    int number;
    int rank;
    int gold;
    int silver;
    int bronze;

    public Country(int number, int gold, int silver, int bronze) {
        this.number = number;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Country country) {
        if (this.gold != country.gold) {
            return country.gold - this.gold;
        }
        if (this.silver != country.silver) {
            return country.silver - this.silver;
        }
        return country.bronze - this.bronze;
    }
}
