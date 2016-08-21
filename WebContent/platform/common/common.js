//弹出信息窗口 title:标题 msgString:提示信息 msgType:信息类型 [error,info,question,warning]
function show(msgString) {
	$.messager.alert("提示", msgString, 0);
}

function show2(msg, fun) {
	$.messager.confirm("提示", msg, fun);
}