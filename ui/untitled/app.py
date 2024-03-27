import requests
from flask import Flask, request, render_template, Blueprint

app = Flask(__name__)
url_blueprint = Blueprint('url_blueprint', __name__)

@app.route('/')
def head_side():
    return render_template("index.html")
@app.route('/encode', methods = ['POST'])
def hello_world():  # put application's code here
    body = request.json

    # url = 'http://encoder-service:8080/api/encode'
    url = 'http://localhost:8081/api/encode'

    x = requests.post(url, json=body)
    return x.text


@app.route('/decode/<url>')
def decode(url):
    x = requests.get(f'http://localhost:8082/api/decode/{url}')
    return x.text

if __name__ == '__main__':
    app.run(port=8083)
