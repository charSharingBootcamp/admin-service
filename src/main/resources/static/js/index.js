var selectedDocuments = new Set();
$(document).ready(() => {

    $(".documentCheckbox").on("click", event => {
        let selected = event.target.checked;
        let title = event.target.name;
        if (selected) {
            selectedDocuments.add(title);
        } else {
            selectedDocuments.delete(title);
        }
    })

    $("#deleteButton").on("click", event => {
        $.ajax({
            url: window.location.href,
            type: 'DELETE',
            data: JSON.stringify(Array.from(selectedDocuments)),
            contentType: "application/json",
            success: function(result) {
                location.reload();
            }
        });
    })
})