package com.goit.feature.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DatabasePopulateService {
    private static PreparedStatement insertStWorker;
    private static PreparedStatement insertStClient;
    private static PreparedStatement insertStProject;
    private static PreparedStatement insertStProjectWorker;

    private static boolean createNewWorker(String name, LocalDate birthday, String level, int salary) {
        try {
            insertStWorker.setString(1, name);
            insertStWorker.setString(2, birthday.toString());
            insertStWorker.setString(3, level);
            insertStWorker.setInt(4, salary);
            return insertStWorker.executeUpdate() == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private static boolean createNewClient(String name) {
        try {
            insertStClient.setString(1, name);
            return insertStClient.executeUpdate() == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private static boolean createNewProject(int client_id, LocalDate start_date, LocalDate finish_date) {
        try {
            insertStProject.setInt(1, client_id);
            insertStProject.setString(2, start_date.toString());
            insertStProject.setString(3, finish_date.toString());
            return insertStProject.executeUpdate() == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    private static boolean createNewProjectWorker(int project_id, int worker_id) {
        try {
            insertStProjectWorker.setInt(1, project_id);
            insertStProjectWorker.setInt(2, worker_id);
            return insertStProjectWorker.executeUpdate() == 1;
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) throws SQLException {
        String insertWorkerSql = "INSERT INTO worker (name, birthday, level, salary) VALUES(?, ?, ?, ?)";
        String insertClientSql = "INSERT INTO client (name) VALUES(?)";
        String insertProjectSql = "INSERT INTO project (client_id, start_date, finish_date) VALUES(?, ?, ?)";
        String insertProjectWorkerSql = "INSERT INTO project_worker (project_id, worker_id) VALUES(?, ?)";

        Database database = Database.getInstance();

        Connection connection = database.getConnection();

        insertStWorker = connection.prepareStatement(insertWorkerSql);
        insertStClient = connection.prepareStatement(insertClientSql);
        insertStProject = connection.prepareStatement(insertProjectSql);
        insertStProjectWorker = connection.prepareStatement(insertProjectWorkerSql);

        createNewWorker("Stephan", LocalDate.parse("1970-01-02"), "Senior", 15000);
        createNewWorker("Galyna", LocalDate.parse("1991-12-05"), "Middle", 3000);
        createNewWorker("Taras", LocalDate.parse("1995-11-29"), "Junior", 1500);
        createNewWorker("Maria", LocalDate.parse("1988-04-17"), "Senior", 8000);
        createNewWorker("Ivan", LocalDate.parse("1992-06-14"), "Middle", 5000);
        createNewWorker("Daryna", LocalDate.parse("1999-06-08"), "Trainee", 700);
        createNewWorker("Oleksandr", LocalDate.parse("2002-10-10"), "Trainee", 500);
        createNewWorker("Tamara", LocalDate.parse("1994-03-12"), "Middle", 4500);
        createNewWorker("Dmytro", LocalDate.parse("1995-01-10"), "Senior", 8800);
        createNewWorker("Kateryna", LocalDate.parse("1997-09-09"), "Trainee", 600);

        createNewClient("Palaie");
        createNewClient("It`s a Good Trip");
        createNewClient("BLOGMAYSTER");
        createNewClient("Sh.t I know life");
        createNewClient("Sergey Nemchinskiy");

        createNewProject(5, LocalDate.parse("2021-09-01"), LocalDate.parse("2023-10-31"));
        createNewProject(5, LocalDate.parse("2022-11-16"), LocalDate.parse("2022-12-17"));
        createNewProject(1, LocalDate.parse("2019-02-14"), LocalDate.parse("2022-11-11"));
        createNewProject(3, LocalDate.parse("2020-06-04"), LocalDate.parse("2021-01-05"));
        createNewProject(2, LocalDate.parse("2019-04-10"), LocalDate.parse("2022-09-27"));
        createNewProject(4, LocalDate.parse("2020-07-07"), LocalDate.parse("2022-12-15"));
        createNewProject(2, LocalDate.parse("2022-06-01"), LocalDate.parse("2023-02-28"));
        createNewProject(3, LocalDate.parse("2015-12-12"), LocalDate.parse("2022-09-11"));
        createNewProject(1, LocalDate.parse("2021-10-24"), LocalDate.parse("2024-12-31"));
        createNewProject(3, LocalDate.parse("2018-04-09"), LocalDate.parse("2022-12-19"));

        createNewProjectWorker(1, 1);
        createNewProjectWorker(1, 2);
        createNewProjectWorker(1, 5);
        createNewProjectWorker(1, 7);
        createNewProjectWorker(1, 10);
        createNewProjectWorker(2, 9);
        createNewProjectWorker(3, 4);
        createNewProjectWorker(3, 6);
        createNewProjectWorker(4, 3);
        createNewProjectWorker(4, 4);
        createNewProjectWorker(4, 5);
        createNewProjectWorker(5, 1);
        createNewProjectWorker(5, 4);
        createNewProjectWorker(5, 9);
        createNewProjectWorker(6, 1);
        createNewProjectWorker(6, 9);
        createNewProjectWorker(6, 10);
        createNewProjectWorker(6, 7);
        createNewProjectWorker(7, 5);
        createNewProjectWorker(8, 1);
        createNewProjectWorker(8, 2);
        createNewProjectWorker(8, 3);
        createNewProjectWorker(8, 4);
        createNewProjectWorker(8, 5);
        createNewProjectWorker(9, 6);
        createNewProjectWorker(9, 7);
        createNewProjectWorker(10, 8);
        createNewProjectWorker(10, 9);
        createNewProjectWorker(10, 10);
    }
}
