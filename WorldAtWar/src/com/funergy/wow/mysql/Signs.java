/*******************************************************************
 * Copyright (c) 2014 Soulpoint Company
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS 
 * ECLIPSE PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR 
 * DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT’S ACCEPTANCE
 * OF THIS AGREEMENT. The full license is available at:
 * http://www.eclipse.org/org/documents/epl-v10.php
 ******************************************************************/
package com.funergy.wow.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.funergy.wow.WorldOfWar;

import nl.soulpoint.api.mysql.SoulPointMySQL;

/**
 * @author Funergy
 *
 */
public class Signs {
	private SoulPointMySQL connection;
	public WorldOfWar main;
	 
	public Signs() {
        connection = new SoulPointMySQL();
    }
	public void openConnection(){
        connection.connect();
	}
	
    public void setupDB() throws SQLException {
                connection.executeUpdate("CREATE TABLE IF NOT EXISTS `SGservers`(`ID` integer,`NAME` varchar(100),`MAP` varchar(100),`PLAYERC` integer,`MAXP` integer,`STATE` varchar(100))");
        }
    public void setId(){
    	try{
    		connection.executeUpdate("INSERT INTO `SGservers`(ID,NAME,MAP,PLAYERC,MAXP,STATE)\nvalues ('"+main.getSignID()+"','"+main.getServerName()+"','" + main.getMapName() + "', '" +0+"','"+16+"','"+"LOBBY"+"');");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    public void setStateIngame(){
    	try {
    		connection.executeUpdate("UPDATE `SGservers` SET STATE="+main.getGameState()+" WHERE ID="+main.getSignID()+";");
    } catch (Exception e) {
            e.printStackTrace();
    }
    }

    	public void setStateLobby(){
        	try {
                connection.executeUpdate("UPDATE `SGservers` SET STATE="+"LOBBY"+" WHERE ID="+main.getSignID()+";");
        } catch (Exception e) {
                e.printStackTrace();
        }
    	
    }
    public void setPlayerc(int playerc){
    	try {
            connection.executeUpdate("UPDATE `SGservers` SET PLAYERC="+main.getLobbyPCount()+" WHERE ID="+main.getSignID()+";");
    } catch (Exception e) {
            e.printStackTrace();
    }
    }
    public String getid(){
 	   
	        try {
	             ResultSet result =connection.select("select STATE from SGservers where ID='" +1 + "'");

	               
	                if (result.next()) {
	                        return result.getString("STATE");
	                } else {
	                        return null;
	                }
	        } catch (Exception e) {
	                e.printStackTrace();
	                return null;
	        }
	    }
}
