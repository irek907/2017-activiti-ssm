/**
 * jquery-validata-1.0.js
 * @author yangpeihong
 * @date 2012-12-04
 * 
 * check type:
 *  mustInput 	 必填限制
 *  mustMoreThan 最小长度限制
 *  mustLessThan 最大长度限制
 *  mustEqualTo  必须等于限制
 *  mustEmail 	 邮箱格式限制
 *  mustInt 	 整数格式限制
 *  mustFloat 	 浮点数限制
 *  mustSelect 	 select框必选限制
 *  mustCheck 	 checkBox框必选限制
 *  mustRadio: 	 radio框必选限制
 *  mustRegular  自定义格式限制
 *  
 *  使用验证表单插件说明：
 *  1、导入此js文件；
 *  
 *  2、调用checkForm方法；如：
 *  	var falg = $.checkForm({
 *			ctrls : [
 *			    {id : "formName", type : "mustInput", par : "", msg : "请输入表单名称！"},
 *			    {id : "formName", type : "mustRegular", par : /^[A-Z][a-zA-Z]+$/, msg : "您输入的表单名称不符合命名规范！"},
 *			    {id : "displayName", type : "mustLessThan", par : "100", msg : "显示名称最大只能输入100个字符！"},
 *			    {id : "formDesc", type : "mustLessThan", par : "200", msg : "表单描述最大只能输入200个字符！"}
 *			],
 *			level : window.frames[0].document
 *		});
 *		根据返回值falg来标识表单验证结果，true成功，false失败;
 *
 *	3、拓展插件：
 *  	插件自带了success和failed方法，如需覆盖请参照下方实例：
 *		$.checkForm({
 *			ctrls : [
 *			    {id : "formName", type : "mustInput", par : "", msg : "请输入表单名称！"},
 *			    {id : "formName", type : "mustRegular", par : /^[A-Z][a-zA-Z]+$/, msg : "您输入的表单名称不符合命名规范！"},
 *			    {id : "displayName", type : "mustLessThan", par : "100", msg : "显示名称最大只能输入100个字符！"},
 *			    {id : "formDesc", type : "mustLessThan", par : "200", msg : "表单描述最大只能输入200个字符！"}
 *			],
 *			level : window.frames[0].document,
 *			success: function(){ 
 *                alert("submit success");
 *                // 验证成功，ajax请求后台...                                       
 *          },
 *          failed: function(msg){  
 *          	alert(msg);
 *          }
 *		});
 *  
 *  4、验证类型解析和说明：
 *  	示列：{id : "formName", type : "mustInput", par : "", msg : "请输入表单名称！"}
 *  	说明：id : "formName"     		id的值为页面id属性；
 *  		  type : "mustInput"  		type的值为验证规则，上面已经对每个验证做了说明；
 *  		  par : "" 	          		par的值是用来比较用的；
 *  		  msg : "请输入表单名称"		msg的值为验证失败提示语；
 *  
 *  5、对每个验证类型的用法进行举例：
 *  	  {id: "txtUserName",type:"mustInput", par:"",msg: "please input your user name"}
 *        {id: "txtPassword",type:"mustInput", par:"",msg: "please input your password"}
 *        {id: "txtPassword",type:"mustMoreThan", par:"3", msg: "length of password must more than 3"}
 *        {id: "txtPassword",type:"mustLessThan", par:"12", msg: "length of password less more than 12"}                   
 *        {id: "txtPasswordAgain",type:"mustEqualTo", par:"txtPassword", msg: "password not math"}
 *        {id: "txtEmail",type:"mustEmail", par:"", msg: "the email you input is invalid!"}
 *        {name: "rdoSex",type:"mustRadio", par:"", msg: "select sex!"}
 *        {id: "txtAge",type:"mustInt", par:"", msg: "age can only be integer!"}
 *        {id: "txtWeight",type:"mustFloat", par:"", msg: "weight can only be float!"}
 *        {id: "selCountry",type:"mustSelect", par:"0", msg: "please select your country!"}  // 说明：par:"0"是select框默认为0，根据具体情况来定义par值
 *        {id: "txtRemark",type:"mustInput", par:"",msg: "please input remark"}
 *        {id: "chkAgree",type:"mustCheck", par:"", msg: "please check to agree our terms!"} 
 *  	
 */
$.extend( {
	options : {
		ctrls: [ ],
		level : '',
		success : function() { return; },
		failed:  function(msg, id){ $.clewMsg(msg, id); }
	},
	
	clewMsg: function(msg, id){
	    alert(msg);
	},
	
	checkForm : function(o) {
		o = $.extend({}, $.options, o);
		var isok = true;
		
		/**
		 * 验证失败
		 * @param ctr
		 * @returns
		 */
		var fail = function(ctr) {
			isok = false;
			o.failed(ctr.msg, ctr.id);
			$("#" + ctr.id, o.level).focus();
			return false;
		}
		
		/**
		 * 验证成功
		 * @param str
		 * @returns
		 */
		var succ = function(str) {
			return true;
		}
		
		/**
		 * 正则表达式验证
		 * @param val
		 * @param expression
		 * @returns
		 */
		var checkRegularExpression = function(val, expression) {
			if(val != "") {
				var matchArray = val.match(expression);
                if (matchArray == null) {
                	return false
                } else {
                	return true;
                }
			} else {
				return true;
			}
		}
		
		/**
		 * 取得字符串的字节长度
		 * @param val
		 * @returns
		 */
		var len = function(str) {
			var i;
			var len = 0;
			for (i = 0; i < str.length; i++) {
				if (str.charCodeAt(i) > 255) {
					len += 2;
				} else {
					len++;
				}
			}
			return len;
		}
		
		/**
		 * 比较两个时间大小 
		 */
		var compareDate = function(date1,date2){
			var dateTime = new Date();
			var date1;
			var date2;
			if (date1.length == 10) {
				date1 = dateTime.stringToDateTime(date1,"yyyy-MM-dd");
				date2 = dateTime.stringToDateTime(date2,"yyyy-MM-dd");
			} else {
				date1 = dateTime.stringToDateTime(date1,"yyyy-MM-dd HH:mm");
				date2 = dateTime.stringToDateTime(date2,"yyyy-MM-dd HH:mm");
			}
			if(date1 > date2){
				return false;
			}
			return true;
		}
		
		// 循环遍历验证
		$.each(o.ctrls, function(i, ctr) {
			switch(ctr.type) {
				case "mustInput":   if($("#" + ctr.id, o.level).val().trim() == "")return fail(ctr); else return succ(ctr);
				case "mustMoreThan":if(len($("#" + ctr.id, o.level).val()) < ctr.par)return fail(ctr); else return succ(ctr);
				case "mustLessThan":if(len($("#" + ctr.id, o.level).val()) > ctr.par)return fail(ctr); else return succ(ctr);
				case "mustEqualTo": if($("#" + ctr.id, o.level).val() != $("#" + ctr.par, o.level).val())return fail(ctr);else return succ(ctr);
				case "mustEmail":   if(!checkRegularExpression($("#" + ctr.id, o.level).val(), /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/))return fail(ctr);else return succ(ctr);
				case "mustInt":     if(!checkRegularExpression($("#" + ctr.id, o.level).val(), /^[0-9]*$/))return fail(ctr);else return succ(ctr); 
				case "mustFloat":   if(!checkRegularExpression($("#" + ctr.id, o.level).val(), /^[0-9]+\.{0,1}[0-9]{0,2}$/))return fail(ctr);else return succ(ctr); 
				case "mustSelect":  if($("#" + ctr.id, o.level).val() == ctr.par)return fail(ctr); else return succ(ctr);
				case "mustCheck":   if($("input[type='checkbox'][name='"+ctr.name+"']:checked").length<1)return fail(ctr); else return succ(ctr);
				case "mustRadio":   if($("input[type='radio'][name='"+ctr.name+"']:checked").length<1)return fail(ctr); else return succ(ctr);
				case "mustRegular": if(!checkRegularExpression($("#" + ctr.id, o.level).val(), ctr.par))return fail(ctr);else return succ(ctr);
				case "compareDate": if(compareDate($("#" + ctr.id, o.level).val(), $("#"+ctr.par).val())) return fail(ctr);else return succ(ctr); 
				case "mustTelphone":if(!checkRegularExpression($("#" + ctr.id, o.level).val(), /^(\+861|1)(3|4|5|8)[0-9]{1}\d{8}$/))return fail(ctr);else return succ(ctr);
				case "mustUrl":     if(!checkRegularExpression($("#" + ctr.id, o.level).val(), /^http[s]?:\/\/[\w-]+(\.[\w-]+)+([\w-\.\/?%&=]*)?$/))return fail(ctr);else return succ(ctr);
				case "mustEnglish": if(!checkRegularExpression($("#" + ctr.id, o.level).val(), /^(\w){1,}$/))return fail(ctr);else return succ(ctr);
			}
		});
		
		return isok;
	}
	
});