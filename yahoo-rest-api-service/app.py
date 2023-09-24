from flask import Flask,jsonify  # Import the 'jsonify' function  # 서버 구현을 위한 Flask 객체 import
from flask_restx import Api, Resource  # Api 구현을 위한 Api 객체 import
import yahoo_fin.stock_info as si

app = Flask(__name__)  # Flask 객체 선언, 파라미터로 어플리케이션 패키지의 이름을 넣어줌.
api = Api(app)  # Flask 객체에 Api 객체 등록


@api.route('/health')  # 데코레이터 이용, '/hello' 경로에 클래스 등록
class HelloWorld(Resource):
  def get(self):  # GET 요청시 리턴 값에 해당 하는 dict를 JSON 형태로 반환
    return {"status": "ok"}


@api.route('/api/stock-info/<string:ticker>')
class StockInfo(Resource):
  def get(self, ticker):
    quote_table = si.get_quote_table(ticker, dict_result=False)
    # Convert the pandas DataFrame to a dictionary
    quote_dict = quote_table.set_index('attribute')['value'].to_dict()

    return jsonify(quote_dict)


# http://localhost:8080/api/stock-info/tickers/sp500
@api.route('/api/stock-info/tickers/sp500')
class StockInfoSp500(Resource):
  def get(self):
    tickers = si.tickers_sp500()
    print(tickers)
    return tickers


# http://localhost:8080/api/stock-info/tickers/nasdaq
@api.route('/api/stock-info/tickers/nasdaq')
class StockInfoNasdaq100(Resource):
  def get(self):
    tickers = si.tickers_nasdaq()
    print(tickers)
    return tickers


@api.route('/api/stock-info/tickers/dow')
class StockInfoDow(Resource):
  def get(self):
    tickers = si.tickers_dow()
    print(tickers)
    return tickers


@api.route('/api/stock-info/tickers/dow')
class StockInfoDow(Resource):
  def get(self):
    tickers = si.tickers_dow()
    print(tickers)
    return tickers


@api.route('/api/stock-info/tickers/others')
class StockInfoOthers(Resource):
  def get(self):
    tickers = si.tickers_other()
    print(tickers)
    return tickers


if __name__ == "__main__":
  app.run(debug=True, host='0.0.0.0', port=3000)
