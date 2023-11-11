package com.example.DataInterview;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class WriteJsonInTextFile {




    public void saveCompetitionInfo(String jsonInput, String filePath) {

        try (FileWriter writer = new FileWriter(filePath, false)) {

            JSONObject jsonObject = new JSONObject(jsonInput);

            if (jsonObject.has("competitions")) {
                JSONArray competitionsArray = jsonObject.getJSONArray("competitions");

                for (int i = 0; i < competitionsArray.length(); i++) {
                    JSONObject competition = competitionsArray.getJSONObject(i);
                    int id = competition.getInt("id");
                    String name = competition.getString("name");
                    String entry = "Competition ID: " + id + ", Name: " + name + "\n";
                    writer.write(entry);
                    System.out.print(entry);
                }
            }

            System.out.println("Competition info saved to file: " + filePath);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }




    public void saveTeamInfo(String jsonInput, String filePath) {

        try (FileWriter writer = new FileWriter(filePath, false)) {

            JSONObject jsonObject = new JSONObject(jsonInput);

            if (jsonObject.has("teams")) {
                JSONArray teamsArray = jsonObject.getJSONArray("teams");

                for (int i = 0; i < teamsArray.length(); i++) {
                    JSONObject team = teamsArray.getJSONObject(i);
                    int id = team.getInt("id");
                    String name = team.getString("name");
                    String entry = "Team ID: " + id + ", Name: " + name + "\n";
                    writer.write(entry);
                    System.out.print(entry);
                }
            }

            System.out.println("Team info saved to file: " + filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
