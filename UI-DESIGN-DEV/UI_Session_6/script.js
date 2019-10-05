 Morris.Donut({
            element: 'pie-chart',
            data: [{
                    label: "London",
                    value: 30
                },
                {

                    label: "Canada",
                    value: 15

                },
                {
                    label: "USA",
                    value: 12

                }
            ]
        });
        var data = [{
                    y: '2009',
                    a: 0,
                    b: 0,
                    c: 0
                }, {
                    y: '2010',
                    a: 150,
                    b: 30,
                    c: 50
                },
                {
                    y: '2011',
                    a: 20,
                    b: 50,
                    c: 150
                },
                {
                    y: '2012',
                    a: 150,
                    b: 80,
                    c: 40
                },
                {
                    y: '2013',
                    a: 20,
                    b: 110,
                    c: 150
                },
                {
                    y: '2014',
                    a: 50,
                    b: 150,
                    c: 40
                },
                {
                    y: '2015',
                    a: 150,
                    b: 170,
                    c: 130
                }
            ],
            config = {
                data: data,
                xkey: 'y',
                ykeys: ['a', 'b', 'c'],
                labels: ['Series A', 'Series B', 'Series C'],
                fillOpacity: 0.6,
                hideHover: 'auto',
                behaveLikeLine: true,
                resize: true,
                pointFillColors: ['#0079FB', '#DE80D2', '#00BCD2'],
                pointStrokeColors: ['white'],
                lineColors: ['#0079FB', '#DE80D2', '#00BCD2']
            };
        config.element = 'line-chart';
        Morris.Line(config);