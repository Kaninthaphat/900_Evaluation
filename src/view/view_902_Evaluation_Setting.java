package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import connect.DBConn;
import connect.SqlSelection;
import model.model_employee;
import model.model_ev_detail;
import model.model_ev_emp;
import model.model_ev_head;

public class view_902_Evaluation_Setting {

	private ListModelList<model_ev_head> model_list_ev_head;
	private model_ev_head select_ev_head;
	
	private ListModelList<model_ev_detail> model_list_ev_detail;
	private model_ev_detail select_ev_detail;
	
	private ListModelList<model_employee> model_list_employee;
	private model_employee select_employee;
	private ListModelList<model_ev_emp> model_list_ev_emp;
	private model_ev_emp select_ev_emp;
	
	private Session session ;
	private String user_login = "";
	private String profile_login = "";
	
	private String searchEmp = "";
	private String searchEmp_View = "";
	private boolean openWindow_emp = false;
	private boolean openWindow_edit = false;
	private boolean openWindow_editdetail = false;
	private boolean disable_option = true;
	private String password_check = "";
	private boolean openWindow_login = true;
	
	private int ev_id = 0;
	private int ev_id_detail = 0;
	private String ev_type;
	private String start_date;
	private String end_date;
	private String ev_topic;
    private String ev_problem;
    private String ev_suggestion;
    
    private int sequen = 0;
    private String evdetail_topic = "";
    
	public ListModelList<model_ev_head> getModel_list_ev_head() {
		return model_list_ev_head;
	}
	public void setModel_list_ev_head(ListModelList<model_ev_head> model_list_ev_head) {
		this.model_list_ev_head = model_list_ev_head;
	}
	public model_ev_head getSelect_ev_head() {
		return select_ev_head;
	}
	public void setSelect_ev_head(model_ev_head select_ev_head) {
		this.select_ev_head = select_ev_head;
	}
	public boolean isOpenWindow_emp() {
		return openWindow_emp;
	}
	public void setOpenWindow_emp(boolean openWindow_emp) {
		this.openWindow_emp = openWindow_emp;
	}
	public String getSearchEmp() {
		return searchEmp;
	}
	public void setSearchEmp(String searchEmp) {
		this.searchEmp = searchEmp;
	}
	public ListModelList<model_employee> getModel_list_employee() {
		return model_list_employee;
	}
	public void setModel_list_employee(ListModelList<model_employee> model_list_employee) {
		this.model_list_employee = model_list_employee;
	}
	public model_employee getSelect_employee() {
		return select_employee;
	}
	public void setSelect_employee(model_employee select_employee) {
		this.select_employee = select_employee;
	}
	
	public ListModelList<model_ev_emp> getModel_list_ev_emp() {
		return model_list_ev_emp;
	}
	public void setModel_list_ev_emp(ListModelList<model_ev_emp> model_list_ev_emp) {
		this.model_list_ev_emp = model_list_ev_emp;
	}
	public model_ev_emp getSelect_ev_emp() {
		return select_ev_emp;
	}
	public void setSelect_ev_emp(model_ev_emp select_ev_emp) {
		this.select_ev_emp = select_ev_emp;
	}
	public String getPassword_check() {
		return password_check;
	}
	public void setPassword_check(String password_check) {
		this.password_check = password_check;
	}
	
	public boolean isDisable_option() {
		return disable_option;
	}
	public void setDisable_option(boolean disable_option) {
		this.disable_option = disable_option;
	}
	
	public String getSearchEmp_View() {
		return searchEmp_View;
	}
	public void setSearchEmp_View(String searchEmp_View) {
		this.searchEmp_View = searchEmp_View;
	}
	
	public String getEv_type() {
		return ev_type;
	}
	public void setEv_type(String ev_type) {
		this.ev_type = ev_type;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getEv_topic() {
		return ev_topic;
	}
	public void setEv_topic(String ev_topic) {
		this.ev_topic = ev_topic;
	}
	public String getEv_problem() {
		return ev_problem;
	}
	public void setEv_problem(String ev_problem) {
		this.ev_problem = ev_problem;
	}
	public String getEv_suggestion() {
		return ev_suggestion;
	}
	public void setEv_suggestion(String ev_suggestion) {
		this.ev_suggestion = ev_suggestion;
	}
	
	public ListModelList<model_ev_detail> getModel_list_ev_detail() {
		return model_list_ev_detail;
	}
	public void setModel_list_ev_detail(ListModelList<model_ev_detail> model_list_ev_detail) {
		this.model_list_ev_detail = model_list_ev_detail;
	}
	public model_ev_detail getSelect_ev_detail() {
		return select_ev_detail;
	}
	public void setSelect_ev_detail(model_ev_detail select_ev_detail) {
		this.select_ev_detail = select_ev_detail;
	}
	
	public boolean isOpenWindow_edit() {
		return openWindow_edit;
	}
	public void setOpenWindow_edit(boolean openWindow_edit) {
		this.openWindow_edit = openWindow_edit;
	}
	
	public int getEv_id() {
		return ev_id;
	}
	public void setEv_id(int ev_id) {
		this.ev_id = ev_id;
	}
	
	public boolean isOpenWindow_editdetail() {
		return openWindow_editdetail;
	}
	public void setOpenWindow_editdetail(boolean openWindow_editdetail) {
		this.openWindow_editdetail = openWindow_editdetail;
	}
	
	public int getSequen() {
		return sequen;
	}
	public void setSequen(int sequen) {
		this.sequen = sequen;
	}
	public String getEvdetail_topic() {
		return evdetail_topic;
	}
	public void setEvdetail_topic(String evdetail_topic) {
		this.evdetail_topic = evdetail_topic;
	}
	public int getEv_id_detail() {
		return ev_id_detail;
	}
	public void setEv_id_detail(int ev_id_detail) {
		this.ev_id_detail = ev_id_detail;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	public String getUser_login() {
		return user_login;
	}
	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}
	public String getProfile_login() {
		return profile_login;
	}
	public void setProfile_login(String profile_login) {
		this.profile_login = profile_login;
	}
	
	public boolean isOpenWindow_login() {
		return openWindow_login;
	}
	public void setOpenWindow_login(boolean openWindow_login) {
		this.openWindow_login = openWindow_login;
	}
	
	@Init
	public void init() {
		System.out.println("@Init");
	}
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
        System.out.println("@AfterCompose");                    
       
        load_ev_head();
    }
	
	@Command
 	@NotifyChange("openWindow_emp")
 	public void onOpenWindow_emp() {
 		openWindow_emp = true;
 	}
	
	@Command
 	@NotifyChange("*")
 	public void onOpenWindow_new() {
		openWindow_edit = true;
		openWindow_emp = false;
		select_ev_head = null;
 	}
	
	@Command
 	@NotifyChange("*")
 	public void onOpenWindow_edit() {
		openWindow_edit = true;
		openWindow_emp = false;
 	}
	
	@Command
 	@NotifyChange("*")
 	public void onNew_Detail() {
		openWindow_edit = false;
		openWindow_emp = false;
		openWindow_editdetail = true;
		select_ev_detail = null;
		ev_id_detail = 0;
		sequen = getModel_list_ev_detail().size()+1;
 	}
	
	@Command
 	@NotifyChange("*")
 	public void onEdit_Detail() {
		openWindow_edit = false;
		openWindow_emp = false;
		openWindow_editdetail = true;
 	}
	
	@Command
 	@NotifyChange("*")
 	public void onCancleWindow() {	
 		openWindow_emp= false;
 		disable_option = true;
 		openWindow_edit = false;
 		openWindow_editdetail = false;
 	}
	
	public void load_ev_head()
	{
		ResultSet rs_ = null;
        List<model_ev_head> list_model = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [VOTE_EV_Q] @search = ''";
        System.out.println(StrSQL);
      
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
        	int i = 1;
            while (rs_.next()) {
            	        
            	model_ev_head model = new model_ev_head();                	
	            	
            	    model.setRow_number(i);
            	    model.setId(rs_.getString("id"));  
	            	model.setStart_date(rs_.getString("start_date"));  
	            	model.setEnd_date(rs_.getString("end_date")); 
	            	model.setEv_topic(rs_.getString("ev_topic")); 
	            	model.setEv_problem(rs_.getString("ev_problem")); 
	            	model.setEv_suggestion(rs_.getString("ev_suggestion"));
	            	model.setLast_update(rs_.getString("last_update"));
	            	model.setLast_updateBy(rs_.getString("last_updateBy"));
	            	model.setIs_active(rs_.getString("is_active"));	 
	            	model.setEmp_amount(rs_.getInt("emp_amount"));
	            	model.setEv_type(rs_.getString("ev_type"));
	            	
	                list_model.add(model);  
            	    i++;
            
            }                	
            model_list_ev_head = new ListModelList<model_ev_head>(list_model);
                             
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				sqlsel.closeConnection();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	@Command
	@NotifyChange("*")
	public void load_employee()
	{
		ResultSet rs_ = null;
        List<model_employee> model_list = new ArrayList<>();      
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [SUS_PERSONAL] @search = '"+searchEmp+"'";
        		
        System.out.println(StrSQL);
        int i=1;
        
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
            while (rs_.next()) {
            	model_employee model = new model_employee();    
            	
            	if(!rs_.getString("PersonCode").equals("BD02"))
            	{
            	model.setRow_Number(i);
            	model.setPersonID(rs_.getString("PersonID"));  
            	model.setPersonCode(rs_.getString("PersonCode"));
            	model.setPersonName_Th(rs_.getString("PersonName_Th"));  
            	model.setPersonName_En(rs_.getString("PersonName_En"));  
            	model.setDepartment_Name(rs_.getString("Department_Name"));             	
            	model.setCompany_Name(rs_.getString("Company_Name"));  
            	model.setPositionNameT(rs_.getString("PositionNameT"));  
            	model.setEmpTypeNameT(rs_.getString("EmpTypeNameT")); 
            	model.setBirthDate(rs_.getString("BirthDate"));
            	model.setSexT(rs_.getString("SexT"));
            	model.setSexE(rs_.getString("SexE"));
            	model.setMaritalT(rs_.getString("MaritalT"));
            	model.setMaritalE(rs_.getString("MaritalE"));  
            	model.setYearold(rs_.getString("yearold"));
            	model.setTelephone(rs_.getString("Telephone"));
            	model.setEmail(rs_.getString("Email"));
            	model.setNickname(rs_.getString("Nickname"));
            	model.setInitialT(rs_.getString("InitialT"));
            	model.setInitialE(rs_.getString("InitialE"));
            	model_list.add(model);  
            	i++;
            	}
            }
            model_list_employee = new ListModelList<model_employee>(model_list); 
            ((ListModelList<model_employee>)model_list_employee).setMultiple(true);
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				sqlsel.closeConnection();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	public void load_ev_detail()
	{
		ResultSet rs_ = null;
        List<model_ev_detail> list_model = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "SELECT * FROM MAS_EV_DETAIL WHERE evhead_id = '"+select_ev_head.getId()+"'";
        System.out.println(StrSQL);
      
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
        	int i = 1;
            while (rs_.next()) {
            	        
            	model_ev_detail model = new model_ev_detail();                	
	            	
            	    model.setRow_number(i);
            	    model.setId(rs_.getString("id"));  
	            	model.setEvhead_id(rs_.getString("evhead_id"));  
	            	model.setSequen(rs_.getInt("sequen")); 
	            	model.setEvdetail_topic(rs_.getString("evdetail_topic")); 	         
	            	model.setLast_update(rs_.getString("last_update"));
	            	model.setLast_updateBy(rs_.getString("last_updateBy"));
	            	model.setIs_active(rs_.getString("is_active"));	
	            	
	                list_model.add(model);  
            	    i++;                          
            }
                               
            model_list_ev_detail = new ListModelList<model_ev_detail>(list_model);
                    
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				sqlsel.closeConnection();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	@Command
	@NotifyChange("*")
	public void onInsert_ev_emp() throws SQLException {
		
		if(model_list_employee.size() > 0 && select_ev_head != null){

			DBConn objConnection = new DBConn();
	 		Connection conn = objConnection.getConnection();
	 		conn = objConnection.getConnection();
	 		
			try{
			
		    String	strxml = "";	
			if(model_list_ev_emp.getSize() > 0){	
				
					  for (Iterator<model_employee> i = model_list_employee.iterator(); i.hasNext();) {
						   model_employee item_ = i.next();	
						   
						   if(((ListModelList<model_employee>)model_list_employee).isSelected(item_)){	
							   
							  boolean  c_sum = true;
							  
							  for (Iterator<model_ev_emp> j = model_list_ev_emp.iterator(); j.hasNext();) {
								  model_ev_emp item_ev = j.next();
									
								   if(item_.getPersonCode().equals(item_ev.getEvd_person_code())){									  
									  c_sum = false; 
								   }
							  } 
							  
							  if(c_sum == true){
								 // System.out.println("-"+item_.getPersonCode() +"-");
								  //------ CREATE XML
								   strxml += "<XmlEmp>";	
								   strxml += "<evhead_id>"+select_ev_head.getId()+"</evhead_id>";	
								   strxml += "<evd_sequen>"+0+"</evd_sequen>";	
								   strxml += "<evd_remark></evd_remark>";	
								   strxml += "<evd_person_code>"+item_.getPersonCode()+"</evd_person_code>";					
								   strxml += "</XmlEmp>" +"\n";		
							  }
							  
						   }
					  }  
					  
					  //-------END FOR------------//
					  
			}else{
				
				   for (Iterator<model_employee> i = model_list_employee.iterator(); i.hasNext();) {
					   model_employee item_ = i.next();	
					   
					   if(((ListModelList<model_employee>)model_list_employee).isSelected(item_)){					   						   		
								   strxml += "<XmlEmp>";	
								   strxml += "<evhead_id>"+select_ev_head.getId()+"</evhead_id>";	
								   strxml += "<evd_sequen>"+0+"</evd_sequen>";	
								   strxml += "<evd_remark></evd_remark>";	
								   strxml += "<evd_person_code>"+item_.getPersonCode()+"</evd_person_code>";					
								   strxml += "</XmlEmp>" +"\n";				   
					   }
				   }			   				   
			}
				
			//System.out.println(strxml);
			if(strxml != ""){
				java.sql.CallableStatement cstmt = conn.prepareCall("{call EV_EMP_INSERT(?,?)}");
				cstmt.setString(1, strxml);		
				cstmt.registerOutParameter(2, Types.INTEGER);
				cstmt.execute();
			}
			onCancleWindow();
			load_ev_emp();
			load_ev_head();
			
			}catch(Exception e){
		   		e.printStackTrace();
		   	}finally {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}	
		}else{
			Messagebox.show("Select Personal !");
		}
		
	}
	
	@Command
	@NotifyChange("*")
	public void load_ev_emp()
	{
		ResultSet rs_ = null;
        List<model_ev_emp> model_list = new ArrayList<>();      
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [EV_EMP_Q] @evhead_id = '"+select_ev_head.getId()+"',@search='"+searchEmp_View+"'";
        		
        System.out.println(StrSQL);
        int i=1;
        
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
            while (rs_.next()) {
            	model_ev_emp model = new model_ev_emp();    
        
            	model.setRow_number(i);
            	model.setId(rs_.getString("id"));
            	model.setEvhead_id(rs_.getString("evhead_id"));
            	model.setEvd_sequen(rs_.getString("evd_sequen"));
            	model.setEvd_remark(rs_.getString("evd_remark"));
            	model.setEvd_person_code(rs_.getString("evd_person_code"));  
            	model.setPersonName_Th(rs_.getString("PersonName_Th"));    
            	model.setDepartment_Name(rs_.getString("Department_Name"));             	           
            	model.setPositionNameT(rs_.getString("PositionNameT"));  
            	model.setInitialT(rs_.getString("initialT"));
            	
            	model_list.add(model);  
            	i++;
            	
            }
            model_list_ev_emp = new ListModelList<model_ev_emp>(model_list); 
            ((ListModelList<model_ev_emp>)model_list_ev_emp).setMultiple(true);
            
            openWindow_emp = false;
        	openWindow_edit = false;
        	openWindow_editdetail = false;
       
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
				sqlsel.closeConnection();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	@Command
	@NotifyChange("*")
	public void onDelete_ev_emp() throws SQLException {
		
		if(model_list_ev_emp.size() > 0){

			DBConn objConnection = new DBConn();
	 		Connection conn = objConnection.getConnection();
	 		conn = objConnection.getConnection();
	 		
			try{
				
			   String	strxml = "";
			   for (Iterator<model_ev_emp> i = model_list_ev_emp.iterator(); i.hasNext();) {
				   model_ev_emp item_ = i.next();	
				
				   if(((ListModelList<model_ev_emp>)model_list_ev_emp).isSelected(item_)){
					   strxml += "<XmlData>";	
					   strxml += "<id>"+item_.getId()+"</id>";						
					   strxml += "</XmlData>";	
				   }
			   }			   
			   
			System.out.println(strxml);
			java.sql.CallableStatement cstmt = conn.prepareCall("{call EV_EMP_DELETE(?,?)}");
			
			cstmt.setString(1, strxml);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			
			onCancleWindow();
			load_ev_emp();
			load_ev_head();
			
			}catch(Exception e){
		   		e.printStackTrace();
		   	}finally {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}	
		}else{
			Messagebox.show("เลือกรายชื่อพนักงาน !", "แจ้งเตือน", 0, searchEmp);
		}
		
	}
	
	
	@Command
	@NotifyChange("*")
	public void onselect_evhead(){
		disable_option = false;
		
		load_ev_emp();
		load_ev_detail();
		
		ev_id = Integer.parseInt(select_ev_head.getId());
		ev_type = select_ev_head.getEv_type();
		ev_topic = select_ev_head.getEv_topic();
		ev_problem = select_ev_head.getEv_problem();
		ev_suggestion = select_ev_head.getEv_suggestion();
	}
	
	
	@Command
	@NotifyChange("*")
	public void onselect_opt(){
		
		if(ev_id == 0){
			Insert_ev_header();
		}else{
			Update_ev_header();
		}
	}
	
	@Command
	@NotifyChange("disable_option")
	public void onselect_emp(){
		disable_option = false;
	}
	
	public void Insert_ev_header()
	{
		DBConn objConnection = new DBConn();
 		Connection conn = objConnection.getConnection();
 		conn = objConnection.getConnection();
 		
        try {
        	Statement statement = conn.createStatement();
        	
            String StrSQL = "INSERT INTO [dbo].[MAS_EV]"+
                    "([ev_type],[start_date],[end_date],[ev_topic],[ev_problem]"+
                    ",[ev_suggestion],[last_update],[last_updateBy],[is_active])"+
                    "VALUES"+
                    "("+
                     "'"+ev_type+"',"+
                     "GETDATE(),"+
                     "GETDATE(),"+
                     "'"+ev_topic+"',"+
                     "'"+ev_problem+"',"+
                     "'"+ev_suggestion+"',"+
                     "GETDATE(),"+
                     "'"+user_login+"',"+
                     "1"+
                    ")";
            
            System.out.println(StrSQL);
        
            statement.executeUpdate(StrSQL);
        	
        	load_ev_head();
        	openWindow_edit = false;
        	ev_id = 0;
             
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
        		conn.close();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	
	public void Update_ev_header()
	{
		DBConn objConnection = new DBConn();
 		Connection conn = objConnection.getConnection();
 		conn = objConnection.getConnection();
 		
        try {
        	Statement statement = conn.createStatement();
        	
            String StrSQL = "UPDATE [dbo].[MAS_EV] "
                   +"SET ev_type =  '"+ev_type+"',"
                      + "ev_topic = '"+ev_topic+"',"
                      + "ev_problem = '"+ev_problem+"',"
                      + "ev_suggestion = '"+ev_suggestion+"',"
                      + "last_update = GETDATE(),"
                      + "last_updateBy = '"+user_login+"' "
                      + " WHERE id = "+ev_id+"";
                
            System.out.println(StrSQL);
        
            statement.executeUpdate(StrSQL);
        	
        	load_ev_head();
        	openWindow_edit = false;
        	ev_id = 0;
             
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
        		conn.close();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	@Command
	@NotifyChange("*")
	public void onselect_optDetail(){
		
		if(ev_id_detail == 0){
			Insert_ev_header_detail();
		}else{
			Update_ev_header_detail();
		}
	}
	
	
	public void Insert_ev_header_detail()
	{
		DBConn objConnection = new DBConn();
 		Connection conn = objConnection.getConnection();
 		conn = objConnection.getConnection();
 		
        try {
        	Statement statement = conn.createStatement();
        	
            String StrSQL = " INSERT INTO dbo.MAS_EV_DETAIL "+
            		        "(evhead_id"+
            	            ",sequen"+
            	            ",evdetail_topic"+
            	            ",last_update"+
            	            ",last_updateBy"+
            	            ",is_active)"+
            	     " VALUES "+
            	           "("+ev_id+","+
            	           " "+sequen+","+
            	           " '"+evdetail_topic+"',"+
            	           " GETDATE(),"+
            	           " '"+user_login+"',"+
            	           " 1"+
            	      ")";
            
            System.out.println(StrSQL);
        
            statement.executeUpdate(StrSQL);
        	
            load_ev_detail();
        	openWindow_editdetail = false;
        	ev_id_detail = 0;
             
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
        		conn.close();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	public void Update_ev_header_detail()
	{
		DBConn objConnection = new DBConn();
 		Connection conn = objConnection.getConnection();
 		conn = objConnection.getConnection();
 		
        try {
        	Statement statement = conn.createStatement();
        	
            String StrSQL = " UPDATE dbo.MAS_EV_DETAIL "+
            		        " SET "+
            	            " sequen = "+sequen+" "+
            	            ",evdetail_topic = '"+evdetail_topic+"' "+
            	            ",last_update = GETDATE() "+
            	            ",last_updateBy = '"+user_login+"' "+
            	            
            	     " WHERE id = "+ev_id_detail+" ";
            	       
            System.out.println(StrSQL);
        
            statement.executeUpdate(StrSQL);
        	
            load_ev_detail();
        	openWindow_editdetail = false;
        	ev_id_detail = 0;
             
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
        		conn.close();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	@Command
	@NotifyChange("*")
	public void Active_ev_header_detail()
	{
		DBConn objConnection = new DBConn();
 		Connection conn = objConnection.getConnection();
 		conn = objConnection.getConnection();
 		
        try {
        	Statement statement = conn.createStatement();
        	
            String StrSQL = " UPDATE dbo.MAS_EV_DETAIL "+
            		        " SET "+
            	            " is_active = 0 "+
            	            ",last_update = GETDATE() "+
            	            ",last_updateBy = '"+user_login+"' "+
            	            
            	     " WHERE id = "+ev_id_detail+" ";
            	       
            System.out.println(StrSQL);
        
            statement.executeUpdate(StrSQL);
        	
            load_ev_detail();
        	openWindow_editdetail = false;
        	ev_id_detail = 0;
             
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	try {
        		conn.close();
			} catch (Exception e) {			
				e.printStackTrace();
			}
        }
	}
	
	@Command
	@NotifyChange({"sequen","ev_id_detail"})
	public void onselect_detail(){
		sequen = select_ev_detail.getSequen();
		ev_id_detail = Integer.parseInt(select_ev_detail.getId());
	}
	
	@Command
	@NotifyChange("*")
	public void on_checkedPassword(){
		
		if(password_check.equals("1999")){
			openWindow_login = false;
		}else{
			password_check = "";
			Messagebox.show("password false!");
		}
		
	}
}
