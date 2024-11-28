layui.use(['table','jquery'], function(){
    var table = layui.table;
    var $ = layui.$;

    // 创建渲染实例
    table.render({
        elem: '#test',
        url:  window.contextPath + 'api/courses', // 此处为静态模拟数据，实际使用时需换成真实接口
        toolbar: '#toolbarDemo',
        defaultToolbar: ['filter', 'exports'],
        // height: 'full-100', // 最大高度减去其他容器已占有的高度差
        css: [ // 重设当前表格样式
            '.layui-table-tool-temp{padding-right: 145px;}'
        ].join(''),
        cellMinWidth: 80,
        totalRow: true, // 开启合计行
        page: true,
        loading: true,
        parseData: function(res) {
            return {
                "code": res.succeed ? 0 : 1,
                "msg": res.msg,
                "count": res.data.total,
                "data": res.data.records
            }
        },
        cols: [[
            {type: 'checkbox', fixed: 'left'},
            {field:'id', fixed: 'left', width:90, title: 'ID', sort: true, totalRow: '合计：'},
            {field:'courseName', width:100, title: '课程名称'},
            {field:'courseDesc', title: '课程描述'},
            {field:'classHour', width:80, title: '课时', sort: true},
            {field:'score', title: '学分', width: 80, sort: true},
            {field:'createBy', width: 100, title: '创建人'},
            {field:'createTime', title:'创建时间', width: 180},
            {field:'updateBy', width: 100, title: '更新人'},
            {field:'updateTime', title:'更新时间', width: 180},
            {fixed: 'right', title:'操作', width: 134, minWidth: 125, templet: '#toolDemo'}
        ]],
        done: function(){
            var id = this.id;
        },
        error: function(res, msg){
            console.log(res, msg)
        }
    });

    // 工具栏事件
    table.on('toolbar(test)', function(obj){
        var id = obj.config.id;
        var checkStatus = table.checkStatus(id);
        switch(obj.event) {
            case 'addCourse':
                layer.open({
                    title: '新增课程',
                    type: 2,
                    area: ['80%','80%'],
                    content: window.contextPath + 'courses/add'
                });
                break;
            case "reloadData":
                table.reload('test');
                break;
        }
    });


    // 触发单元格工具事件
    table.on('tool(test)', function(obj){ // 双击 toolDouble
        var data = obj.data; // 获得当前行数据
        // console.log(obj)
        if(obj.event === 'edit'){
            layer.open({
                title: '编辑 - id:'+ data.id,
                type: 2,
                area: ['80%','80%'],
                content: window.contextPath + 'courses/edit/' + data.id
            });
        } else if(obj.event === 'delete'){
            layer.confirm('真的删除行 [id: '+ data.id +'] 么', function(index){
                // obj.del(); // 删除对应行（tr）的DOM结构
                // 向服务器发送删除请求
                $.ajax({
                    url: window.contextPath + 'api/courses/' + data.id,
                    type: 'DELETE',
                    contentType: 'application/json',
                    dataType: 'json',
                    success: function(res) {
                        if (res.succeed) {
                            var index = layer.alert("删除成功", function () {
                                table.reload('test');
                                layer.close(index);
                            });
                        } else {
                            layer.alert(res.msg);
                        }
                    },
                    error: function(jqXHR, textStatus, errorThrown) {
                        console.error('请求失败:', textStatus, errorThrown);
                    }
                });
            });
        }
    });

});