package jdbcdemo;

import java.sql.*;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
			
			/*dataEntry object for creating tables and inserting data into tables*/
			dataEntry myDataEntry = new dataEntry();
				
			/*Call methods for creating tables*/
			myDataEntry.buildTablePlayers();				
			
			myDataEntry.buildTableTeams();
			
			myDataEntry.buildTableMembers();
				
			myDataEntry.buildTableTournaments();
				
			myDataEntry.buildTableMatches();
			
			myDataEntry.buildTableEarnings();
			
			/*Call methods for inserting data*/
			myDataEntry.insertDataPlayers("players.csv");
			
			myDataEntry.insertDataTeams("teams.csv");
			
			myDataEntry.insertDataMembers("members.csv");
			myDataEntry.insertDataTournaments("tournaments.csv");
			
			myDataEntry.insertDataMatches("matches_v2.csv");
			
			myDataEntry.insertDataEarnings("earnings.csv");
			
			
			
			
	}

}
