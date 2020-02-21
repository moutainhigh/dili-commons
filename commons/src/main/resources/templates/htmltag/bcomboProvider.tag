<script>
    $(function () {
        let option = $.extend(
            {${_option!}},
            <% if( isNotEmpty(_onLoadSuccess) ) {%>
            {onLoadSuccess : ${_onLoadSuccess!}}
            <% } else { %>
                {}
            <% } %>
        );
        $.ajax($.extend(true,{
            <% if( isNotEmpty(_provider) ) {%>
            type: "post",
            url: '/provider/getLookupList.action',
            data: {
                provider: '${_provider}',
                <% if( isNotEmpty(_queryParams) ) {%>
                queryParams: '${_queryParams!}'
                <% } %>
            },
            <% } %>
            dataType: "json",
            success: function (result) {
                $.map(result, function (dataItem) {
                    $('#${_id}').append(template('optionItem', $.extend(dataItem, {
                        selected: '${_value!}' == dataItem.value,
                        value:dataItem["${_valueField!'value'}"],
                        text:dataItem["${_textField!'text'}"]
                    })));
                });

                option.onLoadSuccess && option.onLoadSuccess(result);
            },
            error: function () {
                console.log('数据接口异常');
            }
        },option));
    })
</script>