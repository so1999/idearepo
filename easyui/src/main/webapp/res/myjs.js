function addTab(title, url, closeable) {
    if ($('#aa').tabs('exists', title)) {
        $('#aa').tabs('select', title);
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
        $('#aa').tabs('add', {
            title: title,
            content: content,
            closable: closeable
        })
    }
}

function edit(id, url) {
    var row = $(id).datagrid('getSelected');
    addTab('edit',url + "/" + row.userId + ".html",true);
}