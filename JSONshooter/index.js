const express = require('express')
const app = express()
const shops = require('./shops.js') 

app.use(express.static(__dirname + '/static'));

app.get('/', (req, res) => res.json(shops))

app.listen(process.env.PORT || 3000, () =>
  console.log('JSONshooter for Shopifier listening on port ' + (process.env.PORT || 3000))
)
