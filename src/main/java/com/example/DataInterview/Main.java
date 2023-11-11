package com.example.DataInterview;

import com.example.DataInterview.duckDbConn.DuckDBConnector;
import com.example.DataInterview.requests.DataHttpRequest;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.DataInterview.duckDbConn.DuckDBConnector.*;


public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {


        try (Connection connection = connect()) {
            System.out.println("Connected to DuckDB!");






        } catch (SQLException e) {
            e.printStackTrace();
        }



        String uriComp = "https://api.football-data.org/v4/competitions/";
        String uriTeam = "https://api.football-data.org/v4/competitions/2015/teams";
        String hName="X-Auth-Token";
        String hValue="5423557cc94c4af595af64c6f6401c30";
        String compFilePath = "C:\\WebDevelopment\\BackEnd\\DataInterview\\src\\main\\java\\com\\example\\DataInterview\\jsonCompetition\\competition.txt";
        String teamsFilePath = "C:\\WebDevelopment\\BackEnd\\DataInterview\\src\\main\\java\\com\\example\\DataInterview\\jsonTeams\\teams.txt";



        DataHttpRequest dataHttpRequest = new DataHttpRequest();

        try {
            HttpResponse<String> response=dataHttpRequest.sendFootballDataRequest(uriComp,hName,hValue);

            if(response!=null){

                String jsonOutput = response.body();
                WriteJsonInTextFile writeJsonInTextFile = new WriteJsonInTextFile();
                writeJsonInTextFile.saveCompetitionInfo(jsonOutput,compFilePath);
                //writeJsonInTextFile.saveTeamInfo(jsonOutput,teamsFilePath);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }


}
