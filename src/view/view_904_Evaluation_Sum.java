package view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.util.media.AMedia;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;

import connect.SqlSelection;
import general.DateTime;
import general.ExportExcel;
import model.model_ev_head;

public class view_904_Evaluation_Sum {

	private ListModelList<model_ev_head> model_list_ev_head;
	private model_ev_head select_ev_head;
	
	private ListModelList<model_ev_head> model_list_ev_head_detail;
	private model_ev_head select_ev_head_detail;
	
	private ListModelList<model_ev_head> model_list_ev_head_comment;
	private model_ev_head select_ev_head_comment;
	
	private ListModelList<model_ev_head> model_list_ev_head_desc;
	private model_ev_head select_ev_head_desc;
	
	private String searchEmp ="";
	
	private boolean openWindow_login = true;
	private String password_check = "";
	
	public ListModelList<model_ev_head> getModel_list_ev_head() {
		return model_list_ev_head;
	}
	public void setModel_list_ev_head(ListModelList<model_ev_head> model_list_ev_head) {
		this.model_list_ev_head = model_list_ev_head;
	}
	public ListModelList<model_ev_head> getModel_list_ev_head_detail() {
		return model_list_ev_head_detail;
	}
	public void setModel_list_ev_head_detail(ListModelList<model_ev_head> model_list_ev_head_detail) {
		this.model_list_ev_head_detail = model_list_ev_head_detail;
	}
	public model_ev_head getSelect_ev_head_detail() {
		return select_ev_head_detail;
	}
	public void setSelect_ev_head_detail(model_ev_head select_ev_head_detail) {
		this.select_ev_head_detail = select_ev_head_detail;
	}
	public model_ev_head getSelect_ev_head() {
		return select_ev_head;
	}
	public void setSelect_ev_head(model_ev_head select_ev_head) {
		this.select_ev_head = select_ev_head;
	}
	public String getSearchEmp() {
		return searchEmp;
	}
	public void setSearchEmp(String searchEmp) {
		this.searchEmp = searchEmp;
	}

	public ListModelList<model_ev_head> getModel_list_ev_head_comment() {
		return model_list_ev_head_comment;
	}
	public void setModel_list_ev_head_comment(ListModelList<model_ev_head> model_list_ev_head_comment) {
		this.model_list_ev_head_comment = model_list_ev_head_comment;
	}
	public model_ev_head getSelect_ev_head_comment() {
		return select_ev_head_comment;
	}
	public void setSelect_ev_head_comment(model_ev_head select_ev_head_comment) {
		this.select_ev_head_comment = select_ev_head_comment;
	}
	
	public ListModelList<model_ev_head> getModel_list_ev_head_desc() {
		return model_list_ev_head_desc;
	}
	public void setModel_list_ev_head_desc(ListModelList<model_ev_head> model_list_ev_head_desc) {
		this.model_list_ev_head_desc = model_list_ev_head_desc;
	}
	public model_ev_head getSelect_ev_head_desc() {
		return select_ev_head_desc;
	}
	public void setSelect_ev_head_desc(model_ev_head select_ev_head_desc) {
		this.select_ev_head_desc = select_ev_head_desc;
	}
	public boolean isOpenWindow_login() {
		return openWindow_login;
	}
	public void setOpenWindow_login(boolean openWindow_login) {
		this.openWindow_login = openWindow_login;
	}
	public String getPassword_check() {
		return password_check;
	}
	public void setPassword_check(String password_check) {
		this.password_check = password_check;
	}
	
	@Init
	public void init() {
		System.out.println("@Init");
		load_ev_head();
	}
	
	@AfterCompose
	public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
        System.out.println("@AfterCompose");                    
        
    }
	
	public static String formatSring(double stock) {
		  NumberFormat formatter = new DecimalFormat("#,##0.00");             
	      return formatter.format(stock);
	}
	
	@Command
	@NotifyChange("model_list_ev_head")
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
	public void load_detail(){
		load_ev_detail();
		load_ev_comment();
		load_ev_desc();
	}
	
	public void load_ev_detail()
	{
		ResultSet rs_ = null;
        List<model_ev_head> list_model = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [EV_DETAIL_SUM] @evhead_id = '"+select_ev_head.getId()+"'";
        
        System.out.println(StrSQL);
      
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
        	int i = 1;
        	double sum_totalpoint = 0;
        	double sum_avgpoint = 0;
        	double sum_avgpointTotal = 0;
        	double total_am = 0;
        	
            while (rs_.next()) {
            	        
            	    model_ev_head model = new model_ev_head();                	
	            	
            	    model.setRow_number(i);           	   
	            	model.setEv_topic(rs_.getString("evdetail_topic")); 
	            	model.setSum_point(rs_.getDouble("sum_point"));
	            	model.setSum_total(rs_.getDouble("sum_total"));
	            	model.setAvg_point(rs_.getDouble("avg_point"));
	                list_model.add(model);  
            	                  
            	    sum_totalpoint += rs_.getDouble("sum_point");
            	    sum_avgpoint += rs_.getDouble("avg_point");
            	    total_am += rs_.getDouble("sum_total");         
            	    i++;
            }  
            
            sum_avgpointTotal = sum_avgpoint / (i-1);
            
            model_ev_head model = new model_ev_head();                	
        	
    	    model.setRow_number(i);           	   
        	model.setEv_topic("Total"); 
        	model.setSum_point(sum_totalpoint);
        	model.setSum_total(total_am);
        	model.setAvg_point(sum_avgpointTotal);
            list_model.add(model);  
            
            model_list_ev_head_detail = new ListModelList<model_ev_head>(list_model);
                             
       
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
	
	
	public void load_ev_comment()
	{
		ResultSet rs_ = null;
        List<model_ev_head> list_model = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [EV_DETAIL_COMMENT] @evhead_id = '"+select_ev_head.getId()+"'";
        
        System.out.println(StrSQL);
      
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
        	int i = 1;
        	
            while (rs_.next()) {
            	        
            	    model_ev_head model = new model_ev_head();                	
	            	model.setDepartment_Name(rs_.getString("Department_Name"));
	            	model.setPosition_Name(rs_.getString("Position_Name"));
	            	model.setComment(rs_.getString("Comment"));
            	    model.setRow_number(i);           	   
	            	
	                list_model.add(model);  
            	                           	        
            	    i++;
            }  
                      
            model_list_ev_head_comment = new ListModelList<model_ev_head>(list_model);
                                  
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
	
	
	public void load_ev_desc()
	{
		ResultSet rs_ = null;
        List<model_ev_head> list_model = new ArrayList<>();
        SqlSelection sqlsel = new SqlSelection();
        String StrSQL = "EXEC [EV_DETAIL_DESC] @evhead_id = '"+select_ev_head.getId()+"'";
        
        System.out.println(StrSQL);
      
        try {
        	rs_ = sqlsel.getReSultSQL(StrSQL);
        	int i = 1;
        	
            while (rs_.next()) {
            	        
            	    model_ev_head model = new model_ev_head();  
            	    
	            	model.setDepartment_Name(rs_.getString("Department_Name"));
	            	model.setPosition_Name(rs_.getString("Position_Name"));
	            	model.setEmp_code(rs_.getString("emp_code"));
	            	model.setEv_topic(rs_.getString("evdetail_topic"));
	            	model.setEmp_amount(rs_.getInt("point_value"));
	            	
            	    model.setRow_number(i);           	   
	            	
	                list_model.add(model);  
            	                           	        
            	    i++;
            }  
                      
            model_list_ev_head_desc = new ListModelList<model_ev_head>(list_model);
                                  
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
	public void onCallExcel() {						
		if(model_list_ev_head.size() > 0)
			{	
			try {
				PrintToXls();			
			} catch (IOException e) {				
					e.printStackTrace();
			} 
		}                
	}
	
	private void PrintToXls() throws IOException{								
		
	    ExportExcel excel = new ExportExcel();
	    
		excel.createSheet("คะแนนรวม");
		excel.setColumnWidth(0, 2);
		excel.setColumnWidth(1, 15);
		excel.setColumnWidth(2, 6);
		excel.setColumnWidth(3, 6);
		excel.setColumnWidth(4, 6);
	
		excel.setStyle("H", ExportExcel.CenterStyle, ExportExcel.FontHeaderStyle);
		excel.setStyle("HD", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle);
		excel.setStyle("HEAD", ExportExcel.CenterStyle, ExportExcel.FontColumnStyle);
		excel.setStyle("HDL", ExportExcel.LeftStyle, ExportExcel.FontColumnStyle);
		excel.setStyle("DL", ExportExcel.LeftStyle, ExportExcel.FontDetailStyle);
		excel.setStyle("DC", ExportExcel.CenterStyle, ExportExcel.FontDetailStyle);
		excel.setStyle("DR", ExportExcel.RightStyle, ExportExcel.FontDetailStyle);
		excel.setStyle("DRL", ExportExcel.DoubleStyle, ExportExcel.FontDetailStyle);
		
		excel.setCellValue(1, 1, select_ev_head.getEv_topic(), excel.getStyle("H"));
		excel.setMergedRegion(1,(short)1 ,1 ,(short)4);

		excel.setCellValue(3, 0, "#", excel.getStyle("HEAD"));
		excel.setCellValue(3, 1, "การประเมินเรื่อง", excel.getStyle("HEAD"));
		excel.setCellValue(3, 2, "คะแนนรวม", excel.getStyle("HEAD"));
		excel.setCellValue(3, 3, "จำนวนผู้ประเมิน", excel.getStyle("HEAD"));
		excel.setCellValue(3, 4, "คะแนนเฉี่ย", excel.getStyle("HEAD"));
		
		int rowNum=4;			

		for(model_ev_head report : model_list_ev_head_detail){
			
			excel.setCellValue(rowNum, 0, report.getRow_number(), excel.getStyle("DC"));
			excel.setCellValue(rowNum, 1, report.getEv_topic(), excel.getStyle("DL"));
			excel.setCellValue(rowNum, 2, report.getSum_point(), excel.getStyle("DRL"));
			excel.setCellValue(rowNum, 3, report.getSum_total(), excel.getStyle("DRL"));
			excel.setCellValue(rowNum, 4, report.getAvg_point(), excel.getStyle("DRL"));
			
			rowNum ++;
		}
		excel.setBlankRow(rowNum, 0, 4, excel.getStyle("LB"));
		rowNum++;
		 
		//////////////////////////////////////////////////////////////////////////////////////////////// 
			    
			excel.createSheet("คะแนนรายบุคคล");
			
			excel.setColumnWidth(0, 2);
			excel.setColumnWidth(1, 6);
			excel.setColumnWidth(2, 6);
			excel.setColumnWidth(3, 6);
			excel.setColumnWidth(4, 15);
			excel.setColumnWidth(5, 6);		
					
			excel.setCellValue(1, 1, select_ev_head.getEv_topic(), excel.getStyle("H"));
			excel.setMergedRegion(1,(short)1 ,1 ,(short)5);
			
			excel.setCellValue(3, 0, "#", excel.getStyle("HEAD"));
			excel.setCellValue(3, 1, "แผนก", excel.getStyle("HEAD"));
			excel.setCellValue(3, 2, "ตำแหน่ง", excel.getStyle("HEAD"));
			excel.setCellValue(3, 3, "รหัส", excel.getStyle("HEAD"));
			excel.setCellValue(3, 4, "การประเมิน", excel.getStyle("HEAD"));
			excel.setCellValue(3, 5, "คะแนน", excel.getStyle("HEAD"));
			
			int rowNum2=4;			
	
			for(model_ev_head report : model_list_ev_head_desc){
				
				excel.setCellValue(rowNum2, 0, report.getRow_number(), excel.getStyle("DC"));
				excel.setCellValue(rowNum2, 1, report.getDepartment_Name(), excel.getStyle("DL"));
				excel.setCellValue(rowNum2, 2, report.getPosition_Name(), excel.getStyle("DL"));
				excel.setCellValue(rowNum2, 3, report.getEmp_code(), excel.getStyle("DL"));
				excel.setCellValue(rowNum2, 4, report.getEv_topic(), excel.getStyle("DL"));
				excel.setCellValue(rowNum2, 5, report.getEmp_amount(), excel.getStyle("DRL"));
									
				rowNum2 ++;
			}
			
		 excel.setBlankRow(rowNum2, 0, 5, excel.getStyle("LB"));
		 rowNum2++;
		 
		////////////////////////////////////////////////////////////////////////////////////////////////
				    
		excel.createSheet("ข้อเสนอแนะ");
		
		excel.setColumnWidth(0, 2);
		excel.setColumnWidth(1, 8);
		excel.setColumnWidth(2, 8);
		excel.setColumnWidth(3, 20);		
		
		excel.setCellValue(1, 1, select_ev_head.getEv_topic(), excel.getStyle("H"));
		excel.setMergedRegion(1,(short)1 ,1 ,(short)3);
		
		excel.setCellValue(3, 0, "#", excel.getStyle("HEAD"));
		excel.setCellValue(3, 1, "แผนก", excel.getStyle("HEAD"));
		excel.setCellValue(3, 2, "ตำแหน่ง", excel.getStyle("HEAD"));
		excel.setCellValue(3, 3, "ข้อเสนอแนะ", excel.getStyle("HEAD"));
		
		int rowNum3=4;			
		
		for(model_ev_head report : model_list_ev_head_comment){
		
		excel.setCellValue(rowNum3, 0, report.getRow_number(), excel.getStyle("DC"));
		excel.setCellValue(rowNum3, 1, report.getDepartment_Name(), excel.getStyle("DL"));
		excel.setCellValue(rowNum3, 2, report.getPosition_Name(), excel.getStyle("DL"));
		excel.setCellValue(rowNum3, 3, report.getComment(), excel.getStyle("DL"));
		
		rowNum3 ++;
		}

		excel.setBlankRow(rowNum3, 0, 3, excel.getStyle("LB"));
		rowNum3++;
		 
		String prefix = "SUS_Evaluation_"+ DateTime.getDateNow();
		String fileName = prefix + ".xls";
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		excel.getHssfWorkbook().write(bos);
        ByteArrayInputStream pis = new ByteArrayInputStream(bos.toByteArray());
        AMedia a = new AMedia(fileName, "xls", "application/vnd.ms-excel;charset=UTF-8", pis);  
        Filedownload.save(a);
	
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
