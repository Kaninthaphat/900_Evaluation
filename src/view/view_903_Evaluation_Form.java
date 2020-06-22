package view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import connect.DBConn;
import connect.SqlSelection;
import model.model_comboitem;
import model.model_employee;
import model.model_ev_detail;
import model.model_ev_emp;
import model.model_ev_emp_result;
import model.model_ev_head;

public class view_903_Evaluation_Form {

	private ListModelList<model_ev_head> model_list_ev_head;
	private model_ev_head select_ev_head;
	private ListModelList<model_employee> model_list_employee;
	private model_employee select_employee;
	private ListModelList<model_ev_emp> model_list_ev_emp;
	private model_ev_emp select_ev_emp;
	private ListModelList<model_ev_emp_result> model_list_ev_emp_result;
	private model_ev_emp_result select_ev_emp_result;
	
	private ListModelList<model_ev_detail> model_list_ev_detail;
	private model_ev_detail select_ev_detail;
	
	private ListModelList<model_comboitem> model_list_point;
	private model_comboitem select_point;
	
	private String title_id = "7";
	
	private boolean openWindow_emp = false;
	private boolean openWindow_login = true;
	private boolean check_add = false;
	private boolean openWindow_point = false;
	
	private String password_check = "";
	//private String user_check = "";
	private String searchEmp = "";
	private String profile_login = "";
	private String emp_id ="";
	private String title_lable = "";
	private int total_count = 0;
	private String tatal_play = "";
	private String ev_head_id = "";
	private String remark = "";
    private String last_vote = "";
    private String total_m = "";
    private String total_mvote = "";
    
    private Session session ;
	private String user_login = "";
    
    private int sum_point = 0;
	
    
	public ListModelList<model_comboitem> getModel_list_point() {
		return model_list_point;
	}
	public void setModel_list_point(ListModelList<model_comboitem> model_list_point) {
		this.model_list_point = model_list_point;
	}
	public model_comboitem getSelect_point() {
		return select_point;
	}
	public void setSelect_point(model_comboitem select_point) {
		this.select_point = select_point;
	}
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
	public boolean isOpenWindow_emp() {
		return openWindow_emp;
	}
	public void setOpenWindow_emp(boolean openWindow_emp) {
		this.openWindow_emp = openWindow_emp;
	}
	public boolean isOpenWindow_login() {
		return openWindow_login;
	}
	public void setOpenWindow_login(boolean openWindow_login) {
		this.openWindow_login = openWindow_login;
	}
	
	public String getUser_login() {
		return user_login;
	}
	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public ListModelList<model_ev_emp_result> getModel_list_ev_emp_result() {
		return model_list_ev_emp_result;
	}
	public void setModel_list_ev_emp_result(ListModelList<model_ev_emp_result> model_list_ev_emp_result) {
		this.model_list_ev_emp_result = model_list_ev_emp_result;
	}
	public model_ev_emp_result getSelect_ev_emp_result() {
		return select_ev_emp_result;
	}
	public void setSelect_ev_emp_result(model_ev_emp_result select_ev_emp_result) {
		this.select_ev_emp_result = select_ev_emp_result;
	}
	public String getPassword_check() {
		return password_check;
	}
	public void setPassword_check(String password_check) {
		this.password_check = password_check;
	}
	
	public String getSearchEmp() {
		return searchEmp;
	}
	public void setSearchEmp(String searchEmp) {
		this.searchEmp = searchEmp;
	}
	public String getProfile_login() {
		return profile_login;
	}
	public void setProfile_login(String profile_login) {
		this.profile_login = profile_login;
	}
	public boolean isCheck_add() {
		return check_add;
	}
	public void setCheck_add(boolean check_add) {
		this.check_add = check_add;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getTitle_lable() {
		return title_lable;
	}
	public void setTitle_lable(String title_lable) {
		this.title_lable = title_lable;
	}
	
//	public String getUser_check() {
//		return user_check;
//	}
//	public void setUser_check(String user_check) {
//		this.user_check = user_check;
//	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	
	public String getTatal_play() {
		return tatal_play;
	}
	public void setTatal_play(String tatal_play) {
		this.tatal_play = tatal_play;
	}
	
	
	public String getEv_head_id() {
		return ev_head_id;
	}
	public void setEv_head_id(String ev_head_id) {
		this.ev_head_id = ev_head_id;
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
	
	
	public String getLast_vote() {
		return last_vote;
	}
	public void setLast_vote(String last_vote) {
		this.last_vote = last_vote;
	}

	public String getTotal_m() {
		return total_m;
	}
	public void setTotal_m(String total_m) {
		this.total_m = total_m;
	}
	public String getTotal_mvote() {
		return total_mvote;
	}
	public void setTotal_mvote(String total_mvote) {
		this.total_mvote = total_mvote;
	}
	
	public int getSum_point() {
		return sum_point;
	}
	public void setSum_point(int sum_point) {
		this.sum_point = sum_point;
	}

	public String getTitle_id() {
		return title_id;
	}
	public void setTitle_id(String title_id) {
		this.title_id = title_id;
	}
	
	public boolean isOpenWindow_point() {
		return openWindow_point;
	}
	public void setOpenWindow_point(boolean openWindow_point) {
		this.openWindow_point = openWindow_point;
	}

	@Wire
	Window win_list;
	
	@Init
	public void init() {
		System.out.println("@Init");
		session = Sessions.getCurrent();
		  if (session.getAttribute("session_PersonCode") == null || session.getAttribute("session_PersonCode") == "") {						    
				user_login= "";
				profile_login = "";
		  }else{				
				user_login =  session.getAttribute("session_PersonCode").toString();
				profile_login =  session.getAttribute("session_PersonProfile").toString();				
				set_point();
				load_ev_emp();
				openWindow_emp = true;
	     }
	}
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
        System.out.println("@AfterCompose");                    
       
        
    }
	
	public void set_point(){
		
		ResultSet rs_ = null;
		List<model_comboitem> model_list = new ArrayList<>();  
		SqlSelection sqlsel = new SqlSelection();
	    String StrSQL = "EXEC [SUS_MAS_FIXDATA] @group_id = '7'";
	    System.out.println(StrSQL);
	      
	        try {
	        	rs_ = sqlsel.getReSultSQL(StrSQL);
	            while (rs_.next()) {
	            	model_comboitem model = new model_comboitem();
	       	     	model.setC_Id(rs_.getInt("id"));
	       	     	model.setC_Name(rs_.getString("name_th"));
	       	     	model.setC_Value(rs_.getInt("value"));
	       	     	model_list.add(model); 
	            }
	            model_list_point = new ListModelList<model_comboitem>(model_list);
	     
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
	
	
	public void on_checkedPassword(){
		
		if(model_list_ev_emp.size() > 0){	
			
			if(model_list_ev_emp.get(0).getPws().equals(password_check))
			{
				profile_login = "User Login. "+
						model_list_ev_emp.get(0).getEvd_person_code()+
					" "+model_list_ev_emp.get(0).getInitialT()+
					 ""+model_list_ev_emp.get(0).getPersonName_Th()+
					" "+model_list_ev_emp.get(0).getDepartment_Name();
				
				openWindow_login = false;
				openWindow_emp = true;
				
				emp_id = model_list_ev_emp.get(0).getEvd_person_code();
								
			}else{
				password_check = "";
				Messagebox.show("Password False!");
				openWindow_login = true;
				openWindow_emp = false;
			}
		}else{
			//user_check = "";
			Messagebox.show("User False!");
			openWindow_login = true;
			openWindow_emp = false;
		}
		
	}
	
	
	@Command
	@NotifyChange("*")
	public void load_ev_emp()
	{
		ResultSet rs_ = null;
        List<model_ev_emp> model_list = new ArrayList<>();      
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [KPI_EV_EMP_CHECK_Q] @evd_person_code = '"+user_login+"' ";
        		
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
            	model.setPws(rs_.getString("pws"));
            	model.setEv_topic(rs_.getString("ev_topic"));
            	model.setEv_suggestion(rs_.getString("ev_suggestion"));
            	model_list.add(model);  
            	i++;
            	
            }
            model_list_ev_emp = new ListModelList<model_ev_emp>(model_list); 
            
            profile_login = "ผู้ประเมิณ. "+
					model_list_ev_emp.get(0).getEvd_person_code()+
				" "+model_list_ev_emp.get(0).getInitialT()+
				 ""+model_list_ev_emp.get(0).getPersonName_Th()+
				" "+model_list_ev_emp.get(0).getDepartment_Name();
       
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
	
	
	public void load_ev_head()
	{
		ResultSet rs_ = null;
        List<model_ev_head> list_model = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [VOTE_EV_Q] @search = "+title_id+" ";
        
        System.out.println(StrSQL);
      
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
        	int i = 1;
            while (rs_.next()) {
            	 
            	for (Iterator<model_ev_emp> j = model_list_ev_emp.iterator(); j.hasNext();) {
  				   
            		model_ev_emp item_ = j.next();
            		
            		if(item_.getEvhead_id().equals(rs_.getString("id")))
            		{
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
	            	    
	            	    title_lable = rs_.getString("ev_topic");
	            	    ev_head_id = rs_.getString("id");
	            	    
            		}
            	}
            
            }                	
            model_list_ev_head = new ListModelList<model_ev_head>(list_model);
             
            load_ev_detail();
       
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
	public void load_ev_detail()
	{
		ev_head_id = select_ev_emp.getEvhead_id();
		title_lable = select_ev_emp.getEv_topic();
		
		ResultSet rs_ = null;
        List<model_ev_detail> list_model = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [EV_DETAIL_Q] @evhead_id = '"+ev_head_id+"',@emp_code='"+user_login+"' ";
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
	            	model.setPoint_amount(rs_.getInt("point_value"));
	            	model.setTopic_name(rs_.getString("name_th"));
	            	model.setEvdetail_problem(rs_.getString("evdetail_problem"));
	            	
	                list_model.add(model);  
            	    i++;
                    
            	    remark = rs_.getString("evdetail_problem");
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
    public void on_Update() throws SQLException {
		if(model_list_ev_detail.size() > 0 && model_list_ev_emp != null){			
			call_Update();											
				
		}else{
			Messagebox.show("Warning Is Not Complet", "!Warning", Messagebox.OK, Messagebox.EXCLAMATION);
		}		   	
	}
	
	
	@Command
	@NotifyChange("*")
    public void on_Cancel() {
		openWindow_emp = false;
		Executions.sendRedirect("903_Evaluation_Form.zul");
	}
	
	
	public void call_Update() throws SQLException {
		if(model_list_ev_detail.size() > 0){

			DBConn objConnection = new DBConn();
	 		Connection conn = objConnection.getConnection();
	 		conn = objConnection.getConnection();
	 		
	 		sum_point = 0;	
	 		
			try{
				
			//System.out.println("remark="+remark);
			   String	strxml_item = "<Arrayresult>";
			   for (Iterator<model_ev_detail> i = model_list_ev_detail.iterator(); i.hasNext();) {
				model_ev_detail item_ = i.next();	
				
				strxml_item += "<resultdetail>";	
				strxml_item += "<id>0</id>";	
				strxml_item += "<ev_res_id>0</ev_res_id>";	
				strxml_item += "<evdetail_id>"+item_.getId()+"</evdetail_id>";					
				strxml_item += "<point_value>"+item_.getPoint_amount()+"</point_value>";
				strxml_item += "</resultdetail>";
				
				sum_point += item_.getPoint_amount();
				
			   }
			   strxml_item += "</Arrayresult>";
			   
			    String	strxml = "<result>";
		        strxml += "<id>0</id>";	
		        strxml += "<evhead_id>"+ev_head_id+"</evhead_id>";	
		        strxml += "<evdetail_problem>"+remark+"</evdetail_problem>";	
		        strxml += "<evdetail_suggestion>"+""+"</evdetail_suggestion>";	
		        strxml += "<department_id>"+0+"</department_id>";	
		        strxml += "<position_id>"+0+"</position_id>";	
		        strxml += "<emp_code>"+emp_id+"</emp_code>";	
		        strxml += "<sum_point>"+sum_point+"</sum_point>";
		        strxml += strxml_item;
		        strxml += "</result>";
		          
			
			System.out.println(strxml);
			
			java.sql.CallableStatement cstmt = conn.prepareCall("{call KPI_EVRESULT_INSERT(?,?)}");
			
			cstmt.setString(1, strxml);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			
			 Clients.showNotification("บันทึกผลการประเมินเรียบร้อยแล้ว (OK) ","warning",win_list,"middle_center",5000);
			
			openWindow_emp = true;
			openWindow_point = false;
			remark = "";
			
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
			
		}	
	}
	
	@Command
	@NotifyChange("*")
    public void on_closeToptic() {
		openWindow_emp = false;
		load_ev_detail();
	}
	
	@Command
	@NotifyChange("openWindow_point")
    public void on_openPoint() {
		openWindow_point = true;
	}
	
	@Command
	@NotifyChange("*")
    public void on_select_Point() {
		openWindow_point = false;
		
		select_ev_detail.setPoint_amount(select_point.getC_Value());
		select_ev_detail.setTopic_name(select_point.getC_Name());
	}
}
