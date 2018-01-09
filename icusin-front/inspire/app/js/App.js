import React from 'react';
import {
  render,
} from 'react-dom';
import {
  Router,
  Route,
  Link,
  IndexRoute,
  hashHistory,
  withRouter,
} from 'react-router';
import {
  Container,
  TabBar,
} from 'amazeui-touch';

class App extends React.Component {
  static contextTypes = {
    router: React.PropTypes.object.isRequired,
  };

  render() {
    const {
      location,
      params,
      children,
      ...props,
    } = this.props;
    const {
      router
    } = this.context;
    const transition = children.props.transition || 'sfr';

    return (
      <Container direction="column" id="sk-container">
        <Container
          transition={transition}
          // fade transition example
          // transition='fade'
          // transitionEnterTimeout={450}
          // transitionLeaveTimeout={300}
        >
          {React.cloneElement(children, {key: location.key})}
        </Container>

        <TabBar
          amStyle="success"
        >
          <TabBar.Item
            component={Link}
            icon="home"
            title="首页"
            selected={router.isActive('/', true)}
            to="/"
            onlyActiveOnIndex
          />
          <TabBar.Item
            component={Link}
            icon="info"
            title="表亲"
            badge="4"
            selected={router.isActive('/cusin', true)}
            to="/cusin"
            onlyActiveOnIndex
          />
          <TabBar.Item
            component={Link}
            icon="star-filled"
            title="家族"
            badge="4"
            selected={router.isActive('/family', true)}
            to="/family"
            onlyActiveOnIndex
          />
          <TabBar.Item
            component={Link}
            icon="person"
            title="我"
            badge="4"
            selected={router.isActive('/about', true)}
            to="/profile"
            onlyActiveOnIndex
          />
        </TabBar>
      </Container>
    );
  }
}

// Pages
import Index from './pages/Index';
import Page from './pages/Page';

// withRouter HoC
// @see https://github.com/reactjs/react-router/blob/0616f6e14337f68d3ce9f758aa73f83a255d6db3/upgrade-guides/v2.4.0.md#v240-upgrade-guide
const routes = (
  <Router history={hashHistory}>
    <Route path="/" component={App}>
      <IndexRoute component={Index} />
      <Route path=":page" component={Page} />
    </Route>
  </Router>
);

document.addEventListener('DOMContentLoaded', () => {
  render(routes, document.getElementById('root'));
});
