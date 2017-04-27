/**
 * 截取URL里面的参数
 */
function getURLParameter() {
	var args = new Object();
	var query = location.search.substring(1); // Get query string
	var pairs = query.split("&"); // Break at ampersand
	for ( var i = 0; i < pairs.length; i++) {
		var pos = pairs[i].indexOf('='); // Look for "name=value"
		if (pos == -1)
			continue; // If not found, skip
		var argname = pairs[i].substring(0, pos); // Extract the name
		var value = pairs[i].substring(pos + 1); // Extract the value
		args[argname] = value; // Store as a property
	}
	return args; // Return the object
}

/**
 * 打印消息
 * 
 * @param msg
 */
function setMessage(msg, opt, isBack) {
	if (isBack == undefined) {
		isBack = false;
	}
	if (isBack) {
		$.ligerDialog.alert(msg, "温馨提示", opt, function(type) {
			backMethod();
		});
		return;
	}
	$.ligerDialog.alert(msg, "温馨提示", opt);
}

function setWatting(isClose) {
	if (isClose) {
		$.ligerDialog.closeWaitting();
		return;
	}
	$.ligerDialog.waitting('正在保存中,请稍候...');
}

/**
 * 日期格式化 格式 YYYY/yyyy/YY/yy 表示年份 MM/M 月份 W/w 星期 dd/DD/d/D 日期 hh/HH/h/H 时间 mm/m
 * 分钟 ss/SS/s/S 秒
 */
Date.prototype.format = function(formatStr) {
	var str = formatStr;
	var Week = [ '日', '一', '二', '三', '四', '五', '六' ];

	str = str.replace(/yyyy|YYYY/, this.getFullYear());
	str = str.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100).toString() : '0' + (this.getYear() % 100));

	str = str.replace(/MM/, (this.getMonth() + 1) > 9 ? (this.getMonth() + 1).toString() : '0' + (this.getMonth() + 1));
	str = str.replace(/M/g, (this.getMonth() + 1));

	str = str.replace(/w|W/g, Week[this.getDay()]);

	str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
	str = str.replace(/d|D/g, this.getDate());

	str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
	str = str.replace(/h|H/g, this.getHours());
	str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes().toString() : '0' + this.getMinutes());
	str = str.replace(/m/g, this.getMinutes());

	str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
	str = str.replace(/s|S/g, this.getSeconds());

	return str;
};

/**
 * 
 * @param string(yyyy-MM-dd
 *            HH:mm:ss)
 * @returns
 */
Date.prototype.stringToDateTime = function(string, format) {
	var year = string.split("-");
	var hh = string.split(":");
	var curdate = null;
	if (format == "yyyy-MM-dd HH:mm") {
		// 月份从0~11
		curdate = new Date(year[0], year[1] - 1, year[2].substring(0, 2), hh[0].substring(hh[0].length - 2, hh[0].length), hh[1]);
	} else if(format == "yyyy-MM-dd"){
		curdate = new Date(year[0], year[1] - 1, year[2].substring(0, 2));
	}else {
		// 月份从0~11
		curdate = new Date(year[0], year[1] - 1, year[2].substring(0, 2), hh[0].substring(hh[0].length - 2, hh[0].length), hh[1], hh[2]);
	}
	return curdate;
};

/**
 * 
 * @param string(yyyy-MM-dd)
 * @returns
 */
Date.prototype.stringToDate = function(string, sign) {
	var year = string.split("-");
	var curdate = new Date(year[0], year[1] - 1, year[2]);
	return curdate;
};

Date.prototype.getCurDateString = function(format) {
	var curDate = new Date();
	var sign = "-";
	var year = curDate.getFullYear();
	var month = curDate.getMonth() > 9 ? curDate.getMonth() + 1 : ("0" + (curDate.getMonth() + 1));
	var day = curDate.getDate() > 9 ? curDate.getDate() : "0" + curDate.getDate();
	var hour = curDate.getHours() > 9 ? curDate.getHours() : "0" + curDate.getHours();
	var min = curDate.getMinutes() > 9 ? curDate.getMinutes() : "0" + curDate.getMinutes();
	var second = curDate.getSeconds() > 9 ? curDate.getSeconds() : "0" + curDate.getSeconds();
	var curDate = null;
	if (format == "yyyy-MM-dd") {
		curDate = year + sign + month + sign + day;
	} else if (format == "yyyy-MM-dd HH:mm") {
		curDate = year + sign + month + sign + day + " " + hour + ":" + min;
	} else {
		curDate = year + sign + month + sign + day + " " + hour + ":" + min + ":" + second;
	}

	return curDate;
}

/**
 * 日期相加
 * 
 * @param strInterval
 * @param Number
 * @returns
 */
Date.prototype.DateAdd = function(date, strInterval, Number) {
	var dtTmp = date;
	switch (strInterval) {
	case 's':
		return new Date(Date.parse(dtTmp) + (1000 * Number));
	case 'n':
		return new Date(Date.parse(dtTmp) + (60000 * Number));
	case 'h':
		return new Date(Date.parse(dtTmp) + (3600000 * Number));
	case 'd':
		return new Date(Date.parse(dtTmp) + (86400000 * Number));
	case 'w':
		return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
	case 'q':
		return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number * 3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
	case 'm':
		return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
	case 'y':
		return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
	}
};

/**
 * 日期控件不启用
 */
function disableDate() {
	for ( var i = 0; i < arguments.length; i++) {
		// 日期控件不启用
		$("#" + arguments[i]).ligerGetDateEditorManager().setDisabled();
	}
}

/**
 * 返回到上一个历史记录
 */
function backMethod() {
	window.history.back();
}
