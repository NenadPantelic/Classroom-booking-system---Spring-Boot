import Errors from './Errors'

class Form {
    /**
     * Create a new Form instance.
     *
     * @param {object} data
     */
    constructor(data) {
        this.originalData = data;

        for (let field in data) {
            this[field] = data[field];
        }

        this.errors = new Errors();
    }


    /**
     * Fetch all relevant data for the form.
     */
    data() {
        let data = {};

        for (let property in this.originalData) {
            data[property] = this[property];
        }

        return data;
    }


    /**
     * Reset the form fields.
     */
    reset() {
        for (let field in this.originalData) {
            this[field] = '';
        }

        this.errors.clear();
    }


    /**
     * Send a POST request to the given URL.
     * .
     * @param {string} url
     */
    post(url, data, emit, me) {
        return this.submit('post', url, data, emit, me);
    }


    /**
     * Send a PUT request to the given URL.
     * .
     * @param {string} url
     */
    put(url) {
        return this.submit('put', url);
    }


    /**
     * Send a PATCH request to the given URL.
     * .
     * @param {string} url
     */
    patch(url) {
        return this.submit('patch', url);
    }


    /**
     * Send a DELETE request to the given URL.
     * .
     * @param {string} url
     */
    delete(url) {
        return this.submit('delete', url);
    }


    /**
     * Submit the form.
     *
     * @param {string} requestType
     * @param {string} url
     * @param {string} data
     */
    submit(requestType, url, data = this.data(), emit, me) {


        $.getJSON(url, function (result) {
            me.$emit(emit, result);
        });
        // $.ajax({
        //     url: url,
        //     type: requestType,
        //     dataType: "json",
        //     data: data,
        //     success: function (response) {
        //         self.onSuccess(response);
        //
        //     },
        //     error: function(jqXHR, textStatus, errorThrown) {
        //         self.onFail(textStatus);
        //     }
        // });
    }


    /**
     * Handle a successful form submission.
     *
     * @param {object} data
     */
    onSuccess(data) {
        console.log("uspeh");
      //  this.reset();
    }


    /**
     * Handle a failed form submission.
     *
     * @param {object} errors
     */
    onFail(errors) {
        alert(errors);
        this.errors.record(errors);
    }

    checkIfEmpty(obj) {
        var err = {};
        for (var key in obj) {
            if(obj[key] == "") {
                err[key] =  "Ово поље је обавезно";
                this.errors.record(err);
            }
        }
    }
}

export default Form;