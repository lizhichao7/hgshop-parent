<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>品牌管理列表</h3>
 	<div>
		<input id="firstChar" value="${firstChar}"/>
		<button type="button" class="btn btn-primary" onclick="query()">查询 </button>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">添加 </button>
	</div>
	
	
	<div class="modal fade" id="staticBackdrop" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		 <div class="modal-content">
		 	<div class="modal-header">
        		添加品牌
      		</div>
      		<div class="modal-body">
        	<form id="addbrand">
        		 <div class="form-group">
    				<label for="brandName">品牌名称</label>
    				<input type="text" class="form-control" name="name" id="brandName" aria-describedby="brandNamelHelp">
    				<small id="brandNamelHelp" class="form-text text-muted">请输入品牌名称</small>
  				</div>
  				<div class="form-group form-group-proper">
    				<label for="inputAddress">首字母</label>
    				<input type="text" name="firstChar" class="form-control" id="firstChar" placeholder="1234 Main St">
    				<small id="brandNamelHelp" class="form-text text-muted">请输入首字母</small>
  				</div>
  				<div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary" onclick="commitBrand()">提交</button>
			    </div>
    			
        	</form>
      </div>
		 </div>
	</div>
</div>
<div class="modal fade" id="staticBackdropUpdate" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		 <div class="modal-content">
		 	<div class="modal-header">
        		添加品牌
      		</div>
      		<div class="modal-body">
        	<form id="updatebrand">
        	 <input type="hidden" name="id" id="upId">
        		 <div class="form-group">
    				<label for="brandName">品牌名称</label>
    				<input type="text" class="form-control" name="name" id="brandName" aria-describedby="specNamelHelp">
    				<small id="specNamelHelp" class="form-text text-muted">请输入品牌名称</small>
  				</div>
  				<div class="form-group form-group-proper">
    				<label for="inputAddress">首字母</label>
    				<input type="text" name="firstChar" class="form-control" id="firstChar" placeholder="1234 Main St">
    				<small id="specNamelHelp" class="form-text text-muted">请输入首字母</small>
  				</div>
  				<div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary" onclick="commitUpdateBrand()">提交</button>
			    </div>
    			
        	</form>
      </div>
		 </div>
	</div>
</div>
	
	
	<table class="table">
		<tr>
			<th>id</th>
			<th>品牌名称</th>
			<th>首字母</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pageInfo.list }" var="brand">
		<tr>
			<td>${brand.id}</td>
			<td>${brand.name}</td>
			<td>${brand.firstChar}</td>
			<td>
				<button type="button" class="btn btn-danger" onclick="delBrand(${brand.id})">删除</button>
				<button type="button" class="btn btn-warning" onclick="UpdateBrand(${brand.id})">修改</button>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="3">
				<jsp:include page="../common/page.jsp"></jsp:include>
			</td>
		</tr>
	</table>
	
</body>
<script type="text/javascript">
	/**
	提交数据	
	*/
	function commitBrand(){
		//addbrand
		var formData = new FormData($("#addbrand")[0]);
		$.ajax({url:"/brand/add",
			 // dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
				 if(data=="success"){
					 alert("数据提交成功")
					 $('#staticBackdrop').modal('hide')
				 }else{
					 alert("数据保存失败")
				 }
				 
			  }
			  })
		
	}

	//给添加规格模态框增加关闭以后的事件  
	$('#staticBackdrop').on('hidden.bs.modal', function (e) {
		  // do something...
		refresh();
	})
	
	// 给修改规格模态框增加关闭以后的事件  
	$('#staticBackdropUpdate').on('hidden.bs.modal', function (e) {
		  // do something...
		refresh();
	})
	
	
function UpdateBrand(id) {
		
		
		$.post("/brand/getBrand",{id:id},function(data){
			//规格的id
			$("[name=id]").val(data.id)
			$("[name=name]").val(data.name)
			// 添加规格的选项
			$("[name=firstChar]").val(data.firstChar)
		});
		
		$("#staticBackdropUpdate").modal('show')
}
function commitUpdateBrand() {
	var formData = new FormData($("#updatebrand")[0]);
	$.ajax({url:"/brand/update",
		 // dataType:"json",
		  data:formData,
		  // 让jQuery 不要再提交数据之前进行处理
		  processData : false,
		  // 提交的数据不能加消息头
		  contentType : false,
		  // 提交的方式 
		  type:"post",
		  // 成功后的回调函数
		  success:function(data){
			 if(data=="success"){
				 alert("数据提交成功")
				 $('#staticBackdropUpdate').modal('hide')
			 }else{
				 alert("数据保存失败")
			 }
			 
		  }
		  })
}

function delBrand(id) {
	if(confirm("您确认删除该条数据么？")){
		$.post("/brand/delBrand",{id:id},function(data){
			if(data="success"){
				alert("删除成功")
				refresh();
			}else{
				alert("删除失败")
			}
		});
	}else{
		return;
	}
}


/* 查询 */
function query() {
	var url = "/brand/list?firstChar="+$("#firstChar").val();
	$("#main").load(url)
}

/**
* 分页 
*/
function goPage(pagenum){
	
	var url="/brand/list?firstChar="+$("#firstChar").val()+'&page='+pagenum;
	$("#main").load(url);
}

/**
* 刷新 而且保持查询条件和页码
*/
function refresh(){
	
	var url="/brand/list?firstChar=${firstChar}"+'&page=${pageInfo.pageNum}';
	$("#main").load(url);
}

</script>
</html>