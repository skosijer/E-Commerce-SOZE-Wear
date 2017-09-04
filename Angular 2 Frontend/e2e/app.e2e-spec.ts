import { TShirtsPage } from './app.po';

describe('tshirts App', () => {
  let page: TShirtsPage;

  beforeEach(() => {
    page = new TShirtsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
