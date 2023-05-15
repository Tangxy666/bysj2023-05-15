<template>
    <div>
        <h1>111</h1>
    </div>
</template>

<script>
    let socket;
    console.log(111)
    let username = localStorage.getItem("userName")
    let _this = this;
    if (typeof (WebSocket) == "undefined") {
    console.log("您的浏览器不支持WebSocket");
    } else {
    console.log("您的浏览器支持WebSocket");
    let socketUrl = "ws://localhost:8090/imserver/" + username;
    if (socket != null) {
        socket.close();
        socket = null;
    }
    // 开启一个websocket服务
    socket = new WebSocket(socketUrl);
    //打开事件
    socket.onopen = function () {
        console.log("websocket已打开");
    };
    //  浏览器端收消息，获得从服务端发送过来的文本消息
    socket.onmessage = function (msg) {
        console.log("收到数据====" + msg.data)

        let data = JSON.parse(msg.data)  // 对收到的json数据进行解析， 类似这样的： {"users": [{"username": "zhang"},{ "username": "admin"}]}
        if (data.users) {  // 获取在线人员信息
        _this.users = data.users.filter(user => user.username !== username)  // 获取当前连接的所有用户信息，并且排除自身，自己不会出现在自己的聊天列表里
        } else {
            console.log("有新的消息了！")
        // 如果服务器端发送过来的json数据 不包含 users 这个key，那么发送过来的就是聊天文本json数据
        //  // {"from": "zhang", "text": "hello"}
        if (data.from === _this.chatUser) {

            _this.messages.push(data)
            // 构建消息内容
            _this.createContent(data.from, null, data.text)
        }
        }
    };
    //关闭事件
    socket.onclose = function () {
        console.log("websocket已关闭");
    };
    //发生了错误事件
    socket.onerror = function () {
        console.log("websocket发生了错误");
    }
    }
</script>
