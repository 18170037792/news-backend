$('.select2').select2({
    width: '100%'
});

var news = new $.news();

/**
 * 保存文章
 * @param status
 */
function subArticle(status) {
    /**获取标题*/
    var title = $('#articleForm input[name=title]').val();
    /**获取文章副标题*/
    var subtitle = $('#articleForm input[name=subtitle]').val();
    var tag = $('#articleForm input[name=tags]').val();
    /**获取富文本内容*/
    var content = UE.getEditor('myEditor').getContent();
    if (title == '') {
        news.alertWarn('请输入文章标题');
        return;
    }
    if(subtitle == ''){
        news.alertWarn('请输入文章副标题');
        return;
    }
    /**属性赋值*/
    parseInt($('#articleForm #typeId').val($('#sel').val()));
    $('#content-editor').val(content);
    $("#articleForm #status").val(status);
    var params = $('#articleForm').serialize();
    var url = $('#articleForm #id').val() != '' ? '/user/article/modify' : '/user/article/publish';
    news.post({
        url:url,
        data:params,
        success: function (result) {
            if (result.code == 200) {
                news.alertOk({
                    text:'文章保存成功',
                    then: function () {
                        setTimeout(function () {
                            window.location.href = '/user/article/list';
                        }, 500);
                    }
                });
            } else {
                news.alertError(result.msg || '保存文章失败');
            }
        }
    });
}