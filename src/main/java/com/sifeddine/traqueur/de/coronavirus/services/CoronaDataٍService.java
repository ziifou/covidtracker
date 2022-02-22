package com.sifeddine.traqueur.de.coronavirus.services;

import com.sifeddine.traqueur.de.coronavirus.models.Locationstats;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaDataٍService {
    private static String donneCorona = "https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/latest/owid-covid-latest.csv";
    private List <Locationstats> allStats  = new ArrayList<>();

    public List<Locationstats> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled(cron = "* * 5 * * *")
    public void fetchData() throws IOException, InterruptedException {
        List<Locationstats> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(donneCorona))
                .build();
        HttpResponse<String> HttpResponse = client.send(request, java.net.http.HttpResponse.BodyHandlers.ofString());
        StringReader csvBodyReader = new StringReader(HttpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);

        for (CSVRecord record : records) {
            Locationstats locationStat = new Locationstats();

            locationStat.setPays(record.get("location"));
            locationStat.setNombreTotalDeCas(record.get("total_cases"));
            locationStat.setNombreTotalDeDeces(record.get("total_deaths"));
            locationStat.setPersonnesEntierementVaccinees(record.get("people_fully_vaccinated"));

            newStats.add(locationStat);
        }
        this.allStats = newStats;

    }
}
