import React, {Component} from 'react';
import {Layout, Menu, Breadcrumb, Modal, List} from 'antd';
import {Card, Col, Row} from 'antd';
import axios from 'axios';
import './App.css';

const {Header, Content, Footer} = Layout;
const {Meta} = Card;

class App extends Component {
  state = {
    movies: [],
    visible: false,
    movie: {},
  };

  handleClickShowModel = (id) => {
    let movie = this.state.movies.find(item => item.id === id);
    movie.data = [
      `Title:  ${movie.title}`,
      `Category:  ${movie.category}`,
      `Year:  ${movie.year}`,
      `Director:  ${movie.director}`,
      `Production Company:  ${movie.producer}`,
    ];
    this.setState({movie});
    this.setState({visible: true})
  };

  handleClickCancelModel = () => {
    this.setState({visible: false})
  };

  componentDidMount() {
    axios
      .get('http://localhost:8080/RESTService/resources/restapi/movies')
      .then(response => {
        console.log(response.data);
        this.setState({movies: response.data})
      })
      .catch(error => {
        console.log('error ', error);
      });
  }

  render() {
    const {movies, visible, movie} = this.state;

    return (

      <div className="App">
        <Layout>
          <Header style={{position: 'fixed', zIndex: 1, width: '100%'}}>
            <Menu theme="dark" mode="horizontal" defaultSelectedKeys={['1']} className="myMenu">
              <Menu.Item key="1">Nerdfilx</Menu.Item>
            </Menu>
          </Header>
          <Content className="site-layout" style={{padding: '0 50px', marginTop: 64}}>
            <Breadcrumb style={{margin: '16px 0'}}>
              <Breadcrumb.Item>Home</Breadcrumb.Item>
              <Breadcrumb.Item>List</Breadcrumb.Item>
              <Breadcrumb.Item>Movie & TV Show</Breadcrumb.Item>
            </Breadcrumb>
            <div className="site-layout-background" style={{padding: 24, minHeight: 380}}>
              <div className="site-card-wrapper">
                <div className="mymodel">
                  <Modal
                    width={650}
                    title="Video Detail"
                    visible={visible}
                    onOk={this.handleClickCancelModel}
                    onCancel={this.handleClickCancelModel}
                  >
                    <div className="site-card-wrapper">
                      <Row gutter={12}>
                        <Col span={12}>
                          <Card
                            cover={<img alt="example" src={movie.thumbnail}/>}
                            title={movie.title} bordered={false}>
                          </Card>
                        </Col>
                        <Col span={12}>
                          <Card title="Information" bordered={false}>
                            <List
                              size="small"
                              bordered
                              dataSource={movie.data}
                              renderItem={item => <List.Item>{item}</List.Item>}
                            />
                          </Card>
                        </Col>
                      </Row>
                    </div>
                  </Modal>
                </div>
                <Row gutter={20}>
                  {movies.map(item => {
                    return (
                      <Col span={8} key={item.id}>
                        <Card
                          hoverable
                          onClick={() => this.handleClickShowModel(item.id)}
                          style={{width: 240}}
                          cover={<img alt="Thumbnail" src={item.thumbnail}/>}
                        >
                          <Meta description={item.title}/>
                        </Card>
                      </Col>
                    )
                  })}
                </Row>
              </div>
            </div>
          </Content>
          <Footer style={{textAlign: 'center'}}>Nerdfilx ©2020 Created by Maoru</Footer>
        </Layout>
      </div>
    );
  }
}

export default App;
