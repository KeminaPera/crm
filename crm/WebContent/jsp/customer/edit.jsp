<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.post("${pageContext.request.contextPath}/BaseDict_findByDictTypeCode",{"dict_type_code":"006"},function(data){
			$.each(data,function(i,obj){
				$("#cust_level").append("<option value='"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
			});
			$("#cust_level").val("${model.cust_level.dict_id}");
		},"json"); 
		$.post("${pageContext.request.contextPath}/BaseDict_findByDictTypeCode",{"dict_type_code":"002"},function(data){
			$.each(data,function(i,obj){
				$("#cust_source").append("<option value='"+obj.dict_id+"'>"+obj.dict_item_name+"</option>");
			});
			$("#cust_source option[value='${model.cust_source.dict_id}']").prop("selected","selected");
		},"json");
	});
</script>

<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<s:debug/>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customerAction_update.action"
		method=post>
		<input type="hidden" name="cust_id" value="<s:property value="cust_id"/>"/>
		<input type="hidden" name="customerDetail.cust_id" value="<s:property value="cust_id"/>"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_022.jpg"><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
											style="WIDTH: 180px" maxLength=50 name="cust_name" value="<s:property value="cust_name"/>">
								</td>
								<td>客户级别 ：</td>
								<td>
								<select name="cust_level.dict_id" style="WIDTH: 180px" class="textbox" id="cust_level">
									<option value="">--请选择--</option>
								</select>
								</td>
							</TR>
							
							<TR>
								<td>信息来源：</td>
								<td>
									<select name="cust_source.dict_id" class="textbox" id="cust_source" style="WIDTH: 180px">
										<option value="">--请选择--</option>
									</select>
								</td>
								<td>联系人：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custLinkman" value="<%-- ${customer.custLinkman } --%>">
								</td>
							</TR>
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_phone" value="<s:property value="cust_phone"/>">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="cust_mobile" value="<s:property value="cust_mobile"/>">
								</td>
							</TR>
							
							<TR>
								<td>联系地址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_address" value="<s:property value="customerDetail.cust_address"/>">
								</td>
								<td>邮政编码 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_zip" value="<s:property value="customerDetail.cust_zip"/>">
								</td>
							</TR>
							<TR>
								<td>客户传真 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_fax" value="<s:property value="customerDetail.cust_fax"/>">
								</td>
								<td>客户网址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_website" value="<s:property value="customerDetail.cust_website"/>">
								</td>
							</TR>
							<TR>
								<td>客户营业执照注册号：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_licence" value="<s:property value="customerDetail.cust_licence"/>">
								</td>
								<td>企业法人 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_corporation" value="<s:property value="customerDetail.cust_corporation"/>">
								</td>
							</TR>
							<TR>
								<td>客户注册资金：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_capital" value="<s:property value="customerDetail.cust_capital"/>">
								</td>
								<td>开户银行及帐号 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_bank" value="<s:property value="customerDetail.cust_bank"/>">
								</td>
							</TR>
							<TR>
								<td>客户简介：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_memo" value="<s:property value="customerDetail.cust_memo"/>">
								</td>
								<td>客户地区 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="customerDetail.cust_region" value="<s:property value="customerDetail.cust_region"/>">
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align="center" width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>