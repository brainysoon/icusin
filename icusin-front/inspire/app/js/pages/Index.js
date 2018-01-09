import React from 'react';
import {
  Container,
  List,
  NavBar,
  Group,
  View,
} from 'amazeui-touch';

export default class Index extends React.Component {
  static defaultProps = {
    transition: 'rfr'
  };

  render() {
    return (
      <View>
        <NavBar
          amStyle="success"
          title="表亲网"
        />
        <Container scrollable>
          <Group
            header="欢迎来到表亲网，正在建设中。。。尽请关注！"
            noPadded
          >
          </Group>
        </Container>
      </View>
    );
  }
}
