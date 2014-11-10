package java4s;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.mysql.jdbc.PreparedStatement;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jmat
 */
public class DB {
       
    static Connection con=null;
    static ResultSet rs=null;
    static Statement st=null;
    static PreparedStatement ps=null;
   DB() 
    {
	   try{
        
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/im_sharing","root","justin");
            st=con.createStatement();        
	   }catch(Exception e){
		   System.out.print("Exception occured");
		   
	   }
        }
      
    public String InsertRecord(String Uname,String pro_name, String pro_path, String pro_about, String pro_cam, int Pro_Point, int Comp_no, String pro_mail, String pro_pwd) throws IOException,SQLException
    {
      
       // st.executeUpdate("insert into user_det values('"+Uname+"','"+pro_name+"','"+pro_path+"','"+pro_about+"','"+pro_cam+"','"+Pro_Point+"','"+Comp_no+"','"+pro_mail+"','"+pro_pwd+"')");
       try{ String insertTableSQL = "INSERT INTO user_det"
			+ "(Uname, Pro_name,Pro_ppath,Pro_about,Pro_cam,Pro_rank,Pro_compNo,Pro_mail,Pro_pwd) VALUES"
			+ "(?,?,?,?,?,?,?,?,?)";	
        ps=(PreparedStatement) con.prepareStatement(insertTableSQL);
        ps.setString(1, Uname);
        ps.setString(2, pro_name);
        ps.setString(3, pro_path );
        ps.setString(4, pro_about);
        ps.setString(5, pro_cam);
        ps.setInt(6, Pro_Point);
        ps.setInt(7, Comp_no);
        ps.setString(8,pro_mail );
        ps.setString(9,pro_pwd);
        ps.executeUpdate();
        return "true";
       }catch(Exception e){
    	   System.out.println(e.getMessage());
    	   return "false";}
        
        
    }
    public ResultSet ValidPwd(String email,String pwd) throws SQLException
    {
     try{
        String qry="select Uname,Pro_mail, Pro_pwd,Pro_ppath from user_det where Pro_mail = ?";
       
        ps=(PreparedStatement)
        con.prepareStatement(qry);
       ps.setString(1, email);
       //From here write the code 
     rs=ps.executeQuery();
     
     //String s=rs.getString(1);
       //  System.out.println(s);
     if(rs.next())
     {
                  //LoginActionForm laf =new LoginActionForm();
          
            return rs;
            
            //laf.setPass(rs.getString(3));
            
     }
     }catch(SQLException e)
     {
     throw new SQLException(e);
     }
return rs;
    }

    

public ResultSet searchUser(String lbl) throws SQLException//RETURN AN ARRAY LIST INSTEAD OF RESULTSET
{
	
	try{
        String qry="select Uname from user_det where Uname = ?";
       
        ps=(PreparedStatement)
        con.prepareStatement(qry);
       ps.setString(1,lbl);
       //From here write the code 
       rs=ps.executeQuery();
    
	
	
return rs;
}catch(Exception e)
	{
	throw new SQLException(e);
	
	}

	}

public int uploadIm(String uname,String pro_path)
{
	
	
	try{
		//System.out.println("code is here");
		String insertPic = "INSERT INTO uploaded_pic"
				+ "(uname,pic_path,likes,status) VALUES"
				+ "(?,?,?,?)";
		ps=(PreparedStatement) con.prepareStatement(insertPic);
		ps.setString(1, uname);
		ps.setString(2, pro_path);
		ps.setInt(3, 0);
		ps.setString(4, "Y");
	
		int i=ps.executeUpdate();
		
		if(i!=0)
        return 1;
		return 0;
        
	}catch(Exception e)
	{
		
		
		return 0;
	}


}

    public ResultSet selectImage(String username)
    {
    	
    	  String qry="select pic_path from uploaded_pic where Uname = ?";
          try{
          ps=(PreparedStatement)con.prepareStatement(qry);
          ps.setString(1,username);
          System.out.println(ps);
          rs=ps.executeQuery();
          //System.out.println(rs.getString(2).toString());
          }catch(Exception e){
        	  
        
          }
    	return rs;
    }
    
    public int sendReq(String uname,String funame,String msg) throws SQLException
    {
    	
    	String freq = "INSERT INTO friendship"
				+ "(uname,fname,Msg,aprv) VALUES"
				+ "(?,?,?,?)";
		ps=(PreparedStatement)con.prepareStatement(freq);
		ps.setString(1, uname);
		ps.setString(2, funame);
		ps.setString(3, msg);
		ps.setString(4, "N");
		int i=ps.executeUpdate();
		
		if(i!=0)
        return 1;
		return 0;
    	//return 1;
    }

    public ResultSet requests(String uname) throws SQLException
    {
    ResultSet rs=null;
   
    String qry="select fname from friendship where uname = ? and aprv = ?";
    
    ps=(PreparedStatement)
    con.prepareStatement(qry);
    ps.setString(1,uname);
    ps.setString(2,"N");
   //From here write the code 
    rs=ps.executeQuery();
   
    	
   
    
    
    return rs;

    }
    public void accept(String fname) throws SQLException
    {
    	 String qry="update friendship set aprv='Y' where fname = ?";
    	 ps=(PreparedStatement)
         con.prepareStatement(qry);
    	   ps.setString(1,fname);
    	   ps.executeUpdate();
    

    }
    
    public ResultSet photoByfriends(String uname) throws SQLException
    {
    	
    	String qry="select pic_path,likes from uploaded_pic where uname in(select fname from friendship where uname=? and aprv= ?)";
    	 ps=(PreparedStatement)
    	         con.prepareStatement(qry);
    	    	   ps.setString(1,uname);

    	    	   ps.setString(2,"Y");
    	    	  rs=ps.executeQuery();
    	
    	return rs;
    }
    
    public void like(String picpath) throws SQLException
    {
    	System.out.println(picpath);
    	String sqry="select likes from uploaded_pic where pic_path= ?";
    			 ps=(PreparedStatement)
    	         con.prepareStatement(sqry);
    	    	 ps.setString(1,picpath);
    	rs=ps.executeQuery();
    	System.out.println(con);
    	rs.first();
    	int l=rs.getInt(1);
    	l=l+1;
    	
    	String qry="update uploaded_pic set likes= ? where pic_path=?";
    	ps=(PreparedStatement)
    	         con.prepareStatement(qry);
             	System.out.println(ps);
   	    	    ps.setInt(1,l);
   	    	     ps.setString(2, picpath);
     ps.executeUpdate();
    }
}


/*    static void DeleteRecord() throws IOException,SQLException
    {
        try
        {           
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            sample.ViewRecord();
            System.out.println("Enter USN to delete");
            String s1=br.readLine();
            int a=st.executeUpdate("delete from STUDENTS where USN='"+s1+"'");
            if(a>0)
            {
                System.out.println("Record deleted");
            }
            else
            {
                System.out.println("Record not updated");
            }
            """
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        catch(IOException e2)
        {
            System.out.println("Error:"+e2.getMessage());
        }
    }
    static void UpdateRecord()
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            sample.ViewRecord();
            System.out.println("Enter USN to update");
            String s1 = br.readLine();
            System.out.println("Enter NAME");
            String s2=br.readLine();
            System.out.println("Enter sem");
            int s3=Integer.parseInt(br.readLine());
            System.out.println("Enter age");
            int s4=Integer.parseInt(br.readLine());
            int eupdate=st.executeUpdate("update STUDENT set USN='"+s1+"',ST_NAME='"+s2+"',ST_SEM='"+s3+"',ST_AGE='"+s4+"' where USN='"+s1+"'");
            if(eupdate>0)
            {
                System.out.println("Record updated");
            }
            else
            {
                System.out.println("Record nor updated");
            }
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch(SQLException e2)
        {
            System.out.println("Error:"+e2.getMessage());
        }
    }
    static void ViewRecord() throws IOException,SQLException
    {
        rs=st.executeQuery("select * from STUDENT");
       
        Boolean t=rs.next();
        if(!t)
        {
            System.out.println("No record");
        }
        else
        {
            System.out.println("USN       NAME       SEM       AGE");
            do
            {
                System.out.println(rs.getString(1)+"       "+rs.getString(2)+"       "+rs.getString(3)+"       "+rs.getString(4));
                
            }while(rs.next());
        }
    }
    /**
     * @param args the command line arguments
     */

