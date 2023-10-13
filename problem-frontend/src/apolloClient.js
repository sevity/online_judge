// src/apolloClient.js
import { ApolloClient, InMemoryCache } from '@apollo/client';

const client = new ApolloClient({
  uri: 'https://sevity.com:9993/graphql',  // GraphQL 서버 URL
  cache: new InMemoryCache(),
});

export default client;
