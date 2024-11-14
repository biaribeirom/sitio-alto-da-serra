from flask import Flask, render_template, request, url_for, redirect

app = Flask(__name__)

@app.route('/')
@app.route('/sitio-alto-da-serra')
def index():
    return render_template("tudo.html")

@app.route("/sitio-alto-da-serra/produtos")
def produtos():
    return render_template("teste-catalogo.html")

@app.route("/sitio-alto-da-serra/geleiaamorapreta")
def amorapreta():
    return render_template('amorapreta.html')