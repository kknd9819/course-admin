layui.use(['table', 'dropdown', ], function(){
    var table = layui.table;
    var dropdown = layui.dropdown;

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
        switch(obj.event){
            case 'addCourse':
                layer.open({
                    title: '新增课程',
                    type: 2,
                    area: ['80%','80%'],
                    content: window.contextPath + 'courses/add'
                });
                break;
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(layui.util.escape(JSON.stringify(data)));
                break;
            case "reloadData":
                table.reload('test');
                break;
        };
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
        } else if(obj.event === 'more'){
            // 更多 - 下拉菜单
            dropdown.render({
                elem: this, // 触发事件的 DOM 对象
                show: true, // 外部事件触发即显示
                data: [{
                    title: '查看',
                    id: 'detail'
                },{
                    title: '删除',
                    id: 'del'
                }],
                click: function(menudata){
                    if(menudata.id === 'detail'){
                        layer.msg('查看操作，当前行 ID:'+ data.id);
                    } else if(menudata.id === 'del'){
                        layer.confirm('真的删除行 [id: '+ data.id +'] 么', function(index){
                            obj.del(); // 删除对应行（tr）的DOM结构
                            layer.close(index);
                            // 向服务端发送删除指令
                        });
                    }
                },
                id: 'dropdown-table-tool',
                align: 'right', // 右对齐弹出
                style: 'box-shadow: 1px 1px 10px rgb(0 0 0 / 12%);' // 设置额外样式
            });
        }
    });
    // table 滚动时移除内部弹出的元素
    var tableInst = table.getOptions('test');
    tableInst.elem.next().find('.layui-table-main').on('scroll', function() {
        dropdown.close('dropdown-table-tool');
    });

});