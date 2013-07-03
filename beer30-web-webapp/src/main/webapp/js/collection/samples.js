define(['backbone', 'model/sample'], function (Backbone, Sample) {

    var Samples = Backbone.Collection.extend({

        // Reference to this collection's model.
        model: Sample,
        url:'/api/v1/sample'

    });
    return Samples;
});
