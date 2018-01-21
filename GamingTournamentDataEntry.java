package jdbcdemo;


import java.sql.*;
import java.util.Scanner;
import java.io.*;

public class dataEntry 
{
	
	Connection myConn;
	PreparedStatement myStat;
	String sql = "tempSqlStatement";
	
	public dataEntry()
	{
		try {
		//1. get a DB connection
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/assign4", "root", "root");
		
		//2. create a statement
		myStat = myConn.prepareStatement(sql); 
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	public void buildTablePlayers()
	{
		try {
		String sqlCreatePlayers = "CREATE TABLE IF NOT EXISTS Players"
				+ "(player_id INT PRIMARY KEY, tag VARCHAR(30), real_name VARCHAR(50),"
				+  "nationality CHAR(2), birthday DATE, game_race ENUM('P', 'T', 'Z'))";  
		myStat.executeUpdate(sqlCreatePlayers);
		
		System.out.println("Players table complete");
		
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	public void buildTableTeams()
	{
		try {
		String sqlCreateTeams = "CREATE TABLE IF NOT EXISTS Teams"
				+ "(team_id INT PRIMARY KEY, name VARCHAR(40), founded DATE, disbanded DATE)";
		
		myStat.executeUpdate(sqlCreateTeams);
		
		System.out.println("Teams table complete");
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	
	public void buildTableMembers()
	{
		try {
		String sqlCreateMembers = "CREATE TABLE IF NOT EXISTS Members"
				+ "(player INT, team INT, start_date DATE, end_date DATE," 
				+ "PRIMARY KEY (player, start_date), CONSTRAINT playerKey FOREIGN KEY (player) REFERENCES Players (player_id), CONSTRAINT teamKey FOREIGN KEY (team) REFERENCES Teams (team_id))";
		
		myStat.executeUpdate(sqlCreateMembers);
		
		System.out.println("Members table complete");
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	public void buildTableTournaments()
	{
		try {
		String sqlCreateTournaments = "CREATE TABLE IF NOT EXISTS Tournaments "
				+ "(tournament_id INT PRIMARY KEY, name VARCHAR(100), region VARCHAR(30), major VARCHAR(5))";
		
		myStat.executeUpdate(sqlCreateTournaments);
		System.out.println("Tournaments table complete");
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	public void buildTableMatches()
	{
		try {
		String sqlCreateMatches = "CREATE TABLE IF NOT EXISTS Matches"
				+ "(match_id INT PRIMARY KEY, date DATE, tournament INT, playerA INT,"
				+ "playerB INT, scoreA INT, scoreB INT, offline VARCHAR(5)," 
				+ "CONSTRAINT tournamentKey FOREIGN KEY (tournament) REFERENCES Tournaments (tournament_id),  CONSTRAINT playerAKey FOREIGN KEY (playerA) REFERENCES Players (player_id), CONSTRAINT playerBKey FOREIGN KEY (playerB) REFERENCES Players (player_id))";
				
		myStat.executeUpdate(sqlCreateMatches);
		System.out.println("Matches table complete");	
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}
	
	public void buildTableEarnings()
	{
		try {
		String sqlCreateEarnings = "CREATE TABLE IF NOT EXISTS Earnings"
				+ "(tournament INT, player INT, prize_money INT, position INT," 
				+ "PRIMARY KEY (tournament, player), CONSTRAINT earningsTournamentKey FOREIGN KEY (tournament) REFERENCES Tournaments (tournament_id), CONSTRAINT earningsPlayerKey FOREIGN KEY (player) REFERENCES Players (player_id))";
		
		myStat.executeUpdate(sqlCreateEarnings);
		System.out.println("Earnings table complete");
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
		}
	}

	public void insertDataPlayers(String updateDataFile)
	{
		String playerId; 
		String tag;
		String realName;
		String nationality;
		String birthday;
		String gameRace;
		
		String dataFile = updateDataFile;
		File file = new File(dataFile);
		try {
			
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) 
			{
				String data = inputStream.nextLine();
				String [] values = data.split(",");
				
				playerId = values[0]; 
				tag = values[1];
				realName = values[2];
				nationality = values[3];
				birthday = values[4];
				gameRace = values[5];
				
				/*
				System.out.println("id " + playerId );
				System.out.println("tag " + tag );
				System.out.println("real_name " + realName );
				System.out.println("nationality " + nationality );
				System.out.println("birthday " + birthday );
				System.out.println("gameRace " + gameRace );
				*/
				
				//int tempPlayerId = Integer.parseInt(playerId);
				
				/*if (tempPlayerId < 365)
				{
				System.out.println("num of values: " + values.length);
				System.out.println("values[0]: " + values[0] );
				System.out.println("values[1]: " + values[1] );
				System.out.println("values[2]: " + values[2] );
				System.out.println("values[3]: " + values[3] );
				System.out.println("values[4]: " + values[4] );
				System.out.println("values[5]: " + values[5] );
				}*/
				
				
				String sqlInsertDataPlayers = "INSERT INTO Players"
								+ "(player_id, tag, real_name, nationality, birthday, game_race)"
								+ " values (" + playerId + ", " + tag + ", " + 
								realName + ", " + nationality + ", " 
								+ birthday + ", " + gameRace + " )";
						
						
				myStat.executeUpdate(sqlInsertDataPlayers);
				
				
				
			}// end while
			System.out.println("Players data inserted");
			inputStream.close();
		} catch (Exception e) {
			
			e.printStackTrace();	
		}
		
	}//end insertDataPlayers()
	
	public void insertDataTeams(String updateDataFile)
	{
		String teamId; 
		String name;
		String founded;
		String disbanded;
		
		String dataFile = updateDataFile;
		File file = new File(dataFile);
		try {
			
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) 
			{
				String data = inputStream.nextLine();
				String [] values = new String[4]; 
						values = data.split(",");
				
				teamId = values[0]; 
				name = values[1];
				founded = values[2];
				if (values.length == 4)
				{
				disbanded = values[3];
				}
				else 
				{
					disbanded = "null";
				}
				/*
				System.out.println("teamId " + teamId );
				System.out.println("name " + name );
				System.out.println("founded " + founded );
				System.out.println("disbanded " + disbanded );
				*/
				String sqlInsertDataTeams = "INSERT INTO Teams"
								+ "(team_id, name, founded, disbanded)"
								+ " values (" + teamId + ", " + name + ", " + 
								founded + ", " + disbanded + " )";
						
						
				myStat.executeUpdate(sqlInsertDataTeams);
				
				
			}// end while
			System.out.println("Teams data inserted");
			inputStream.close();
		} catch (Exception e) {
			
			e.printStackTrace();	
		}
		
	}// end insertDataTeams()
	
	
	public void insertDataTournaments(String updateDataFile)
	{
		String tournamentId; 
		String name;
		String region;
		String major;
		
		
		String dataFile = updateDataFile;
		File file = new File(dataFile);
		try {
			
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) 
			{
				String data = inputStream.nextLine();
				String [] values = data.split(",");
				
				tournamentId = values[0]; 
				name = values[1];
				if (values[2] != "KR" || values[2] != "EU" || values[2] != "AM" || values[2] != "AS")
				{
					region = "null";
				}
				else
				{
					region = values[2];
				}
				major = values[3];
			
						
						
				/*		
				System.out.println("tournId " + tournamentId );
				System.out.println("name " + name);
				System.out.println("region " + region );
				System.out.println("major " + major);
				*/
				
				String sqlInsertDataTournaments = "INSERT INTO Tournaments"
								+ "(tournament_id, name, region, major)"
								+ " values (" + tournamentId + ", " + name + ", " + 
								region + ", " + major + " )";
						
						
				myStat.executeUpdate(sqlInsertDataTournaments);
				
				
			}// end while
			System.out.println("Tournaments data inserted");
			inputStream.close();
		} catch (Exception e) {
			
			e.printStackTrace();	
		}
		
	}// end insertDataTournaments()
	
	
	public void insertDataMatches(String updateDataFile)
	{
		String matchId; 
		String date;
		String tournament;
		String playerA;
		String playerB;
		String scoreA;
		String scoreB;
		String offline;
		
		String dataFile = updateDataFile;
		File file = new File(dataFile);
		try {
			
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) 
			{
				String data = inputStream.nextLine();
				String [] values = data.split(",");
				
				matchId = values[0]; 
				date = values[1];
				tournament = values[2];
				playerA = values[3];
				playerB = values[4];
				scoreA = values[5];
				scoreB = values[6];
				offline = values[7];
						
						
				/*		
				System.out.println("matchId " + matchId );
				System.out.println("date " + date );
				System.out.println("tournament " + tournament );
				System.out.println("playerA " + playerA );
				System.out.println("playerB " + playerB );
				System.out.println("scoreA " + scoreA );
				System.out.println("scoreB " + scoreB );
				System.out.println("offline " + offline );
				*/
				
				String sqlInsertDataMatches = "INSERT INTO Matches"
								+ "(match_id, date, tournament, playerA, playerB, scoreA, scoreB, offline)"
								+ " values (" + matchId + ", " + date + ", " + 
								tournament + ", " + playerA + ", " + playerB + ", " + scoreA + ", " 
								+ scoreB + ", " + offline + " )";
						
						
				myStat.executeUpdate(sqlInsertDataMatches);
				
				
			}// end while
			System.out.println("Matches data inserted");
			inputStream.close();
		} catch (Exception e) {
			
			e.printStackTrace();	
		}
		
	}// end insertDataMatches()
	
	public void insertDataMembers(String updateDataFile)
	{
		String playerId; 
		String team;
		String startDate;
		String endDate;
		
		
		String dataFile = updateDataFile;
		File file = new File(dataFile);
		try {
			
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) 
			{
				String data = inputStream.nextLine();
				String [] values = data.split(",");
				
				playerId = values[0]; 
				team = values[1];
				startDate = values[2];
				if (values.length > 3)
				{
					 endDate = values[3]; 
				}
				else
				{
					endDate = "null";
				}
				
			
						
						
						
				/*System.out.println("playerId " + tournamentId );
				System.out.println("name " + name);
				System.out.println("region " + region );
				System.out.println("major " + major);
				*/
				
				String sqlInsertDataMembers = "INSERT INTO Members"
								+ "(player, team, start_date, end_date)"
								+ " values (" + playerId + ", " + team + ", " + 
								startDate + ", " + endDate + " )";
						
						
				myStat.executeUpdate(sqlInsertDataMembers);
				
				
			}// end while
			System.out.println("Members data inserted");
			inputStream.close();
		} catch (Exception e) {
			
			e.printStackTrace();	
		}
		
	}// end insertDataMembers()
	
	
	public void insertDataEarnings(String updateDataFile)
	{
		String tournamentId; 
		String playerId;
		String prizeMoney;
		String position;
		
		
		String dataFile = updateDataFile;
		File file = new File(dataFile);
		try {
			
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()) 
			{
				String data = inputStream.nextLine();
				String [] values = data.split(",");
				
				tournamentId = values[0]; 
				playerId = values[1];
				prizeMoney = "null";
				position = values[3];
			
						
						
				/*		
				System.out.println("tournId " + tournamentId );
				System.out.println("name " + name);
				System.out.println("region " + region );
				System.out.println("major " + major);
				*/
				
				String sqlInsertDataEarnings = "INSERT INTO Earnings"
								+ "(tournament, player, prize_money, position)"
								+ " values (" + tournamentId + ", " + playerId + ", " + 
								prizeMoney + ", " + position + " )";
						
						
				myStat.executeUpdate(sqlInsertDataEarnings);
				
				
			}// end while
			System.out.println("Earnings data inserted");
			inputStream.close();
		} catch (Exception e) {
			
			e.printStackTrace();	
		}
		
	}// end insertDataEarnings()
	
	
}
