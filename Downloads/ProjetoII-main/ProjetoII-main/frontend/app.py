from flask import Flask, render_template

app = Flask(__name__)


@app.route("/")
@app.route("/sitio-alto-da-serra")
@app.route("/sitio-alto-da-serra/home")
def index():
	return render_template("tudo.html")


@app.route("/sitio-alto-da-serra/produtos")
def produtos():
	return render_template("teste-catalogo.html")


@app.route("/sitio-alto-da-serra/sobre-nos")
def sobrenos():
	return render_template("sobrenos.html")


@app.route("/sitio-alto-da-serra/geleiaamorapreta")
def amorapreta():
	return render_template("amorapreta.html")


@app.route("/sitio-alto-da-serra/admin")
def admin():
	return render_template("admin.html")


# GRRR EU ODEIO FLASK PQP N ME FAZ MAIS MEXER COM PYTHON CARA


# serve static content
@app.route("/frontend/static/<path:path>")
def static_proxy(path):
	return app.send_static_file(path)


if __name__ == "__main__":
	app.run(debug=True)
