import logo from './logo.svg';
import './App.css';
import { ThemeProvider } from '@mui/material';
import { darkTheme } from './theme/darktheme';
import Navbar from './Page/Navbar/Navbar';

function App() {
  return (
    <ThemeProvider theme={darkTheme}>

      <Navbar/>

    </ThemeProvider>
  );
}

export default App;
